package com.example.flightsearcher.flight.data.mapper

import com.example.flightsearcher.flight.data.AirportEntity
import com.example.flightsearcher.flight.data.FavoriteFlightEntity
import com.example.flightsearcher.flight.data.FlightSearchDao
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

suspend fun FavoriteFlightEntity.toFlight(
    dao: FlightSearchDao
): Flight {
    val departureAirportName = dao.getAirportFromCode(departureAirportCode).airportName
    val destinationAirportName = dao.getAirportFromCode(destinationAirportCode).airportName
    return Flight(
        departureAirportCode = departureAirportCode,
        destinationAirportCode = destinationAirportCode,
        departureAirportName = departureAirportName,
        destinationAirportName = destinationAirportName
    )
}
suspend fun Flight.toFlightUi(
    dao: FlightSearchDao
): FlightUi {
    val isFavoriteResult = dao.getFavoriteNullable(departureAirportCode, destinationAirportCode) != null

    return FlightUi(
        departureAirportCode = departureAirportCode,
        departureAirportName = departureAirportName,
        destinationAirportCode = destinationAirportCode,
        destinationAirportName = destinationAirportName,
        isFavorite = isFavoriteResult
    )
}

fun FlightUi.toFlight(): Flight {
    return Flight(
        departureAirportCode = departureAirportCode,
        destinationAirportCode = destinationAirportCode,
        departureAirportName = departureAirportName,
        destinationAirportName = departureAirportName
    )
}

fun Flight.toFavoriteFlightEntity(): FavoriteFlightEntity {
    return FavoriteFlightEntity(
        id = 0,
        departureAirportCode = departureAirportCode,
        destinationAirportCode = destinationAirportCode
    )
}