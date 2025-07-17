package com.example.flightsearcher.flight.data

import com.example.flightsearcher.flight.domain.Airport
import com.example.flightsearcher.flight.domain.Flight

class FlightGenerator {
    fun generateFlightsFromAirport(departureAirport: Airport, airports: List<Airport>): List<Flight> {
        return airports
            .filter { it != departureAirport }
            .map { destinationAirport ->
                Flight(
                    departureAirportCode = departureAirport.airportCode,
                    destinationAirportCode = destinationAirport.airportCode,
                    departureAirportName = departureAirport.airportName,
                    destinationAirportName = destinationAirport.airportName
                )
            }
    }
}