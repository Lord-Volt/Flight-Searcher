package com.example.flightsearcher.flight.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class AirportEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "iata_code")
    val airportCode: String,
    @ColumnInfo(name = "name")
    val airportName: String,
    @ColumnInfo(name = "passengers")
    val passengersCount: Int
)
