package com.example.flightsearcher.flight.presentation.model

data class FlightUi(
    val departureAirportCode: String,
    val departureAirportName: String,
    val destinationAirportCode: String,
    val destinationAirportName: String,
    val isFavorite: Boolean
)

