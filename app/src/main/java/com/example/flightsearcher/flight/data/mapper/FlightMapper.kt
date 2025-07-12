package com.example.flightsearcher.flight.data.mapper

import com.example.flightsearcher.flight.data.AirportEntity
import com.example.flightsearcher.flight.domain.Airport
import com.example.flightsearcher.flight.presentation.model.AirportUi

fun AirportEntity.toAirport(): Airport {
    return Airport(
        airportCode = airportCode,
        airportName = airportName
    )
}

fun Airport.toAirportUi(): AirportUi {
    return AirportUi(
        airportCode = airportCode,
        airportName = airportName
    )
}