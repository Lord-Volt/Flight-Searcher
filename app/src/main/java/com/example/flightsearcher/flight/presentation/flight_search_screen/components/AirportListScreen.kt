package com.example.flightsearcher.flight.presentation.flight_search_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.ui.theme.FlightSearcherTheme
import com.example.flightsearcher.flight.presentation.sampleAirports

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
    FlightSearcherTheme {
        AirportListScreen(
            airports = sampleAirports,
            onClick = {},
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize()
        )
    }
}