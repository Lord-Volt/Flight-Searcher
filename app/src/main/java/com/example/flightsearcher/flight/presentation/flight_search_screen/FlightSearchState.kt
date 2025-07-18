package com.example.flightsearcher.flight.presentation.flight_search_screen

import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.flight.presentation.model.FlightUi

data class FlightSearchState(
    val airports: List<AirportUi> = emptyList(),
    val searchFieldText: String = "",
    val selectedAirport: AirportUi? = null,
    val airportFlights: List<FlightUi> = emptyList()
)