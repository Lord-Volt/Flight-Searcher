package com.example.flightsearcher.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.example.flightsearcher.flight.data.FlightSearchDatabase
import com.example.flightsearcher.flight.data.UserPreferencesRepository
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

    single<DataStore<Preferences>> {
        PreferenceDataStoreFactory.create(
            produceFile = { androidContext().preferencesDataStoreFile("user_preferences") }
        )
    }

    single { UserPreferencesRepository(get()) }

    viewModelOf(::FlightSearchViewModel)
}