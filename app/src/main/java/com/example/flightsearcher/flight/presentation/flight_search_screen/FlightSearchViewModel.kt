package com.example.flightsearcher.flight.presentation.flight_search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearcher.flight.data.FlightGenerator
import com.example.flightsearcher.flight.data.FlightSearchDao
import com.example.flightsearcher.flight.data.UserPreferencesRepository
import com.example.flightsearcher.flight.data.mapper.toAirport
import com.example.flightsearcher.flight.data.mapper.toAirportUi
import com.example.flightsearcher.flight.data.mapper.toFavoriteFlightEntity
import com.example.flightsearcher.flight.data.mapper.toFlight
import com.example.flightsearcher.flight.data.mapper.toFlightUi
import com.example.flightsearcher.flight.presentation.model.FlightUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transformLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FlightSearchViewModel(
    private val dao: FlightSearchDao,
    private val userPreferencesRepository: UserPreferencesRepository
): ViewModel() {

    private val _state = MutableStateFlow(FlightSearchState())
    val state = _state.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val favoriteFlights: StateFlow<List<FlightUi>> = dao.getAllFavorites()
        .transformLatest { flightEntities ->
            val favoriteFlightsUi = mutableListOf<FlightUi>()
            for (it in flightEntities) {
                val flightDomain = it.toFlight(dao)
                val flightUi = flightDomain.toFlightUi(dao)
                favoriteFlightsUi.add(flightUi)
            }
            emit(favoriteFlightsUi)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    init {
        viewModelScope.launch {
            val savedSearchText = userPreferencesRepository.searchFieldText.first()
            if (savedSearchText.isEmpty()) {
                onAction(FlightSearchAction.OnClearSearch)
            } else {
                onAction(FlightSearchAction.OnSearchFieldChange(savedSearchText))
            }
        }
    }
    fun onAction(action: FlightSearchAction) {
        when(action) {
            is FlightSearchAction.OnAirportClick -> {
                _state.update {
                    it.copy(
                        selectedAirport = action.airport
                    )
                }
                viewModelScope.launch(Dispatchers.IO) {
                    val airports = dao.getAllAirports()
                        .map { it.toAirport() }

                    val flights = FlightGenerator()
                        .generateFlightsFromAirport(action.airport.toAirport(), airports)
                        .map { it.toFlightUi(
                            dao = dao
                        ) }

                    withContext(Dispatchers.Main) {
                        _state.update { it.copy(
                            airportFlights = flights
                        ) }
                    }
                }
            }

            is FlightSearchAction.OnFavoriteClick -> {
                val flightUiToToggle = action.flight
                val newFavoriteState = !flightUiToToggle.isFavorite

                viewModelScope.launch {
                    val flightEntity = flightUiToToggle.toFlight().toFavoriteFlightEntity()
                    if (newFavoriteState) {
                        dao.addFavorite(flightEntity)
                    } else {
                        dao.removeFavorite(dao.getFavorite(flightUiToToggle.departureAirportCode, flightUiToToggle.destinationAirportCode))
                    }

                    withContext(Dispatchers.Main) {
                        _state.update { state ->
                            val updatedFlights = state.airportFlights.map { flightUi ->
                                if (flightUi.departureAirportCode == flightUiToToggle.departureAirportCode && flightUi.destinationAirportCode == flightUiToToggle.destinationAirportCode) {
                                    flightUi.copy(isFavorite = newFavoriteState)
                                } else {
                                    flightUi
                                }
                            }
                            state.copy(airportFlights = updatedFlights)
                        }
                    }
                }
            }

            is FlightSearchAction.OnSearchFieldChange -> {
                if (action.searchText.isNotEmpty()) {
                    _state.update {
                        it.copy(
                            searchFieldText = action.searchText,
                            selectedAirport = null,
                            airportFlights = emptyList()
                        )
                    }

                    viewModelScope.launch {
                        userPreferencesRepository.saveSearchFieldData(action.searchText)
                    }

                    viewModelScope.launch(Dispatchers.IO) {
                        val airports = dao.getAirportsByQueryOrderedByPassengers(action.searchText)
                            .map { it.toAirport().toAirportUi() }
                        _state.update {
                            it.copy(
                                airports = airports
                            )
                        }
                    }
                } else {
                    onAction(FlightSearchAction.OnClearSearch)
                }
            }

            is FlightSearchAction.OnClearSearch -> {
                _state.update {
                    it.copy(
                        airports = emptyList(),
                        searchFieldText = "",
                        selectedAirport = null,
                        airportFlights = favoriteFlights.value
                    )
                }
                viewModelScope.launch {
                    userPreferencesRepository.saveSearchFieldData("")
                }
            }
        }
    }
}