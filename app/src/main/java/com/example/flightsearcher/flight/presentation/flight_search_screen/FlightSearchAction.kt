package com.example.flightsearcher.flight.presentation.flight_search_screen

import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.flight.presentation.model.FlightUi

sealed interface FlightSearchAction {
    data class OnSearchFieldChange(val searchText: String) : FlightSearchAction
    data class OnAirportClick(val airport: AirportUi) : FlightSearchAction
    data class OnFavoriteClick(val flight: FlightUi) : FlightSearchAction
}