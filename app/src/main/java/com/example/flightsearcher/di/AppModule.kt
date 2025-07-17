package com.example.flightsearcher.di

import androidx.room.Room
import com.example.flightsearcher.flight.data.FlightSearchDatabase
import com.example.flightsearcher.flight.presentation.flight_search_screen.FlightSearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            FlightSearchDatabase::class.java,
            "flight_search.db"
        )
            .createFromAsset("database/flight_search.db")
            .build()
    }

    single { get<FlightSearchDatabase>().dao }

    viewModelOf(::FlightSearchViewModel)
}