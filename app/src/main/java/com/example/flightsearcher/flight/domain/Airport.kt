package com.example.flightsearcher.flight.domain

data class Airport(
    val id: Int,
    val airportCode: String,
    val airportName: String,
    val passengersCount: Int
)