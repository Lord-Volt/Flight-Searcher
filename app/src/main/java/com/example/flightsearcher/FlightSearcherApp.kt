package com.example.flightsearcher

import android.app.Application
import com.example.flightsearcher.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FlightSearcherApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FlightSearcherApp)
            androidLogger()

            modules(appModule)
        }
    }
}