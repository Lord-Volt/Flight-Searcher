package com.example.flightsearcher.flight.domain

data class Flight(
    val departureAirportCode: String,
    val destinationAirportCode: String,
    val departureAirportName: String,
    val destinationAirportName: String
)
