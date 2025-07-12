package com.example.flightsearcher.flight.presentation.flight_search_screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.flightsearcher.flight.presentation.flight_search_screen.components.AirportListScreen
import com.example.flightsearcher.flight.presentation.flight_search_screen.components.FlightListScreen
import com.example.flightsearcher.flight.presentation.flight_search_screen.components.FlightSearchTopBar
import com.example.flightsearcher.flight.presentation.flight_search_screen.components.SearchField
import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.flight.presentation.model.FlightUi
import com.example.flightsearcher.flight.presentation.sampleAirports
import com.example.flightsearcher.flight.presentation.sampleFlights
import com.example.flightsearcher.ui.theme.FlightSearcherTheme
import com.example.flightsearcher.ui.theme.LocalTheme
import com.example.flightsearcher.ui.theme.darkThemeColors
import com.example.flightsearcher.ui.theme.lightThemeColors

@Composable
fun FlightSearchScreenUi(
    state: FlightSearchState,
    onQueryChange: (String) -> Unit,
    onAirportClick: (AirportUi) -> Unit,
    onFavoriteClick: (FlightUi) -> Unit,
) {
    val theme = LocalTheme.current
    Scaffold(
        topBar = { FlightSearchTopBar() }, // maybe add dark light toggle
        containerColor = theme.surface,
        contentColor = theme.surfaceLight
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SearchField(
                searchText = state.searchFieldText,
                onValueChange = onQueryChange
            )
            if (state.selectedAirport == null && state.searchFieldText.isNotEmpty()) {
                AirportListScreen(
                    airports = state.airports,
                    onClick = onAirportClick
                )
            } else {
                FlightListScreen(
                    state = state,
                    onClick = onFavoriteClick
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun FlightSearchScreenPreview() {
    FlightSearcherTheme {
        val themeColors = if(isSystemInDarkTheme()) darkThemeColors else lightThemeColors
        CompositionLocalProvider(LocalTheme provides themeColors) {
            FlightSearchScreenUi(
                state = FlightSearchState(
                    airports = sampleAirports,
                    searchFieldText = "PUT TEXT HERE TO SEARCH!!!",
                    selectedAirport = null,
                    selectedAirportFlights = sampleFlights
                ),
                onQueryChange = {},
                onAirportClick = {},
                onFavoriteClick = {}
            )
        }
    }
}