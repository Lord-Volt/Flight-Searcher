package com.example.flightsearcher.flight.data.mapper

import com.example.flightsearcher.flight.data.AirportEntity
import com.example.flightsearcher.flight.domain.Airport
import com.example.flightsearcher.flight.domain.Flight
import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.flight.presentation.model.FlightUi

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

fun AirportUi.toAirport(): Airport {
    return Airport(
        airportCode = airportCode,
        airportName = airportName
    )
}

fun Flight.toFlightUi(): FlightUi {
    return FlightUi(
        departureAirportCode = departureAirportCode,
        departureAirportName = departureAirportName,
        destinationAirportCode = destinationAirportCode,
        destinationAirportName = destinationAirportName,
        isFavorite = false
    )
}