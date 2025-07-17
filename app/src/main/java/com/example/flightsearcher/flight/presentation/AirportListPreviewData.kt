package com.example.flightsearcher.flight.presentation // or com.yourapp.ui.airport.preview

import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.flight.presentation.model.FlightUi

val sampleAirports = listOf(
    AirportUi(airportCode = "JFK", airportName = "John F. Kennedy International Airport"),
    AirportUi(airportCode = "LAX", airportName = "Los Angeles International Airport"),
    AirportUi(airportCode = "ORD", airportName = "O'Hare International Airport"),
    AirportUi(airportCode = "ATL", airportName = "Hartsfield-Jackson Atlanta International Airport"),
    AirportUi(airportCode = "DFW", airportName = "Dallas/Fort Worth International Airport")
)

val sampleFlights = listOf(
    FlightUi(
        departureAirportCode = "JFK",
        departureAirportName = "John F. Kennedy International Airport",
        destinationAirportCode = "LAX",
        destinationAirportName = "Los Angeles International Airport",
        isFavorite = false
    ),
    FlightUi(
        departureAirportCode = "JFK",
        departureAirportName = "John F. Kennedy International Airport",
        destinationAirportCode = "ORD",
        destinationAirportName = "O'Hare International Airport",
        isFavorite = false
    ),
    FlightUi(
        departureAirportCode = "JFK",
        departureAirportName = "John F. Kennedy International Airport",
        destinationAirportCode = "ATL",
        destinationAirportName = "Hartsfield–Jackson Atlanta International Airport",
        isFavorite = false
    ),
    FlightUi(
        departureAirportCode = "JFK",
        departureAirportName = "John F. Kennedy International Airport",
        destinationAirportCode = "DFW",
        destinationAirportName = "Dallas/Fort Worth International Airport",
        isFavorite = true
    )
)
