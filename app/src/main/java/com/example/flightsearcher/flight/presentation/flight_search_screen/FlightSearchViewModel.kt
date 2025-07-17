package com.example.flightsearcher.flight.presentation.flight_search_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearcher.flight.data.FlightGenerator
import com.example.flightsearcher.flight.data.FlightSearchDao
import com.example.flightsearcher.flight.data.mapper.toAirport
import com.example.flightsearcher.flight.data.mapper.toAirportUi
import com.example.flightsearcher.flight.data.mapper.toFlightUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FlightSearchViewModel(
    private val dao: FlightSearchDao
): ViewModel() {

    private val _state = MutableStateFlow(FlightSearchState())
    val state = _state.asStateFlow()

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
                        .map { it.toFlightUi() }

                    withContext(Dispatchers.Main) {
                        _state.update { it.copy(
                            selectedAirportFlights = flights
                        ) }
                    }
                }
            }

            is FlightSearchAction.OnFavoriteClick -> {

            }

            is FlightSearchAction.OnSearchFieldChange -> {
                Log.d("Text", action.searchText)

                if (action.searchText.isNotEmpty()) {
                    _state.update {
                        it.copy(
                            searchFieldText = action.searchText,
                            selectedAirport = null,
                            selectedAirportFlights = emptyList()
                        )
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
                        selectedAirportFlights = null
                    )
                }
            }
        }
    }
}