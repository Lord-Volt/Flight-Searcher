package com.example.flightsearcher.flight.presentation.flight_search_screen

import androidx.lifecycle.ViewModel
import com.example.flightsearcher.flight.data.FlightSearchDao
import com.example.flightsearcher.flight.data.mapper.toAirport
import com.example.flightsearcher.flight.data.mapper.toAirportUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FlightSearchViewModel(
    private val dao: FlightSearchDao
): ViewModel() {

    private val _state = MutableStateFlow(FlightSearchState())
    val state = _state.asStateFlow()

    fun onAction(action: FlightSearchAction) {
        when(action) {
            is FlightSearchAction.OnAirportClick -> {

            }
            is FlightSearchAction.OnFavoriteClick -> {

            }
            is FlightSearchAction.OnSearchFieldChange -> {
                val airports = dao.getAirportsByQueryOrderedByPassengers(state.value.searchFieldText)
                    .map { it.toAirport().toAirportUi() }
                _state.update {
                    it.copy(
                        searchFieldText = action.searchText,
                        airports = airports
                    )
                }
            }
        }
    }
}