package com.example.flightsearcher.flight.presentation.flight_search_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightsearcher.flight.presentation.flight_search_screen.FlightSearchState
import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.flight.presentation.sampleFlights
import com.example.flightsearcher.ui.theme.FlightSearcherTheme

@Composable
fun FlightListScreen(
    state: FlightSearchState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp),
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

@PreviewLightDark
@Composable
fun FlightListScreenPreview() {
    FlightSearcherTheme {
        FlightListScreen(
            state = FlightSearchState(
                selectedAirport = AirportUi("JFK", "John F. Kennedy International Airport"),
                selectedAirportFlights = sampleFlights
            ),
            onClick = { },
            modifier = Modifier.background(Color.White)
        )
    }
}