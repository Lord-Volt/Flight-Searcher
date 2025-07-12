package com.example.flightsearcher.flight.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class FavoriteFlightEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "departure_code")
    val departureAirportCode: String,
    @ColumnInfo(name = "destination_code")
    val destinationAirportCode: String
)