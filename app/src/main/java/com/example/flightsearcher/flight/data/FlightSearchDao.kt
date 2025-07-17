package com.example.flightsearcher.flight.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface FlightSearchDao {

    @Query("SELECT * from airport WHERE iata_code LIKE '%' || :query || '%' OR name LIKE '%' || :query || '%' ORDER BY passengers DESC")
    fun getAirportsByQueryOrderedByPassengers(query: String): List<AirportEntity>

    @Query("SELECT * from airport")
    fun getAllAirports(): List<AirportEntity>

    // add favorite, remove favorite and get favorites (flow)
}