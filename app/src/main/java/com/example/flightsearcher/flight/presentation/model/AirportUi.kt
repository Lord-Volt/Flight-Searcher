package com.example.flightsearcher.flight.presentation.model

import com.example.flightsearcher.flight.domain.Airport

data class AirportUi(
    val airportCode: String,
    val airportName: String
)

fun Airport.toAirportUi(): AirportUi {
    return AirportUi(
        airportCode = airportCode,
        airportName = airportName
    )
}
