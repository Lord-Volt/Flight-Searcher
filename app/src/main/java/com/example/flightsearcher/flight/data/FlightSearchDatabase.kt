package com.example.flightsearcher.flight.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [AirportEntity::class, FavoriteFlightEntity::class],
    version = 1
)
abstract class FlightSearchDatabase: RoomDatabase() {
    abstract val dao: FlightSearchDao
    // maybe separate dao for favorites
}