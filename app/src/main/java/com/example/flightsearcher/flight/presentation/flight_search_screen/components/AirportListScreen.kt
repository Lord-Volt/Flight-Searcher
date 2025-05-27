package com.example.flightsearcher.flight.presentation.flight_search_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.flight.presentation.sampleAirports
import com.example.flightsearcher.ui.theme.FlightSearcherTheme
import com.example.flightsearcher.ui.theme.LocalTheme
import com.example.flightsearcher.ui.theme.darkThemeColors
import com.example.flightsearcher.ui.theme.lightThemeColors

@Composable
fun AirportListScreen(
    airports: List<AirportUi>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(airports) { airport ->
            AirportListItem(
                airport = airport,
                onClick = onClick
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun AirportListScreenPreview() {

    val themeColors = if(isSystemInDarkTheme()) darkThemeColors else lightThemeColors

    CompositionLocalProvider(LocalTheme provides themeColors) {
        FlightSearcherTheme {
            AirportListScreen(
                airports = sampleAirports,
                onClick = {},
                modifier = Modifier
                    .background(color = themeColors.surface)
                    .fillMaxSize()
            )
        }
    }
}