package com.example.flightsearcher.flight.presentation.model

data class FlightUi(
    val departureAirportCode: String,
    val departureAirportName: String,
    val arrivalAirportCode: String,
    val arrivalAirportName: String,
    val isFavorite: Boolean
)

