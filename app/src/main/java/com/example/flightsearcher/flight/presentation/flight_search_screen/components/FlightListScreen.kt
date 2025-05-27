package com.example.flightsearcher.flight.presentation.flight_search_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightsearcher.flight.presentation.flight_search_screen.FlightSearchState
import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.flight.presentation.sampleFlights
import com.example.flightsearcher.ui.theme.FlightSearcherTheme
import com.example.flightsearcher.ui.theme.LocalTheme
import com.example.flightsearcher.ui.theme.darkThemeColors
import com.example.flightsearcher.ui.theme.lightThemeColors

@Composable
fun FlightListScreen(
    state: FlightSearchState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val theme = LocalTheme.current
    if (state.selectedAirportFlights != null && state.selectedAirport != null) {
        Column(
            modifier = modifier
                .background(color = theme.surface)
                .fillMaxSize()
                .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = "Flights from ${state.selectedAirport.airportCode}",
                fontWeight = FontWeight.Bold,
                color = theme.textPrimary,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
            )
            LazyColumn(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state.selectedAirportFlights) { flight ->
                    FlightListItem(
                        flight = flight,
                        onClick = onClick
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun FlightListScreenPreview() {
    FlightSearcherTheme {
        val themeColors = if(isSystemInDarkTheme()) darkThemeColors else lightThemeColors
        CompositionLocalProvider(LocalTheme provides themeColors) {
            FlightListScreen(
                state = FlightSearchState(
                    selectedAirport = AirportUi("JFK", "John F. Kennedy International Airport"),
                    selectedAirportFlights = sampleFlights,
                    searchText = ""
                ),
                onClick = { }
            )
        }
    }
}