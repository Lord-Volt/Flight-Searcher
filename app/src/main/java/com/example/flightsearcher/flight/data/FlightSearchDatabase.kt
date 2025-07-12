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

    companion object {
        @Volatile
        private var Instance: FlightSearchDatabase? = null

        fun getDatabase(context: Context): FlightSearchDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    FlightSearchDatabase::class.java,
                    "flight_search.db"
                )
                    .createFromAsset("database/flight_search.db")
                    .fallbackToDestructiveMigration(false)
                    .build().also { Instance = it }
            }
        }
    }
}