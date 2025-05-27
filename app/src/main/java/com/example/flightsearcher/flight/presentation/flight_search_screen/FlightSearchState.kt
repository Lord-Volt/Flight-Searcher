package com.example.flightsearcher.flight.presentation.flight_search_screen

import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.flight.presentation.model.FlightUi

data class FlightSearchState(
    val airports: List<AirportUi> = emptyList(),
    val searchText: String,
    val selectedAirport: AirportUi?,
    val selectedAirportFlights: List<FlightUi>?
)