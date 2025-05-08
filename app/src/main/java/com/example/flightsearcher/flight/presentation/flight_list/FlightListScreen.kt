package com.example.flightsearcher.flight.presentation.flight_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightsearcher.flight.presentation.flight_search_screen.FlightSearchState

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
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "Depart",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Row {
                        Text(
                            text = flight.departureAirportCode,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 14.sp
                        )
                        Text(
                            text = flight.departureAirportName,
                            modifier = Modifier.alignByBaseline(),
                            fontSize = 14.sp
                        )
                    }
                    Text(
                        text = "Arrive",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Row {
                        Text(
                            text = flight.arrivalAirportCode,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 14.sp
                        )
                        Text(
                            text = flight.arrivalAirportName,
                            modifier = Modifier.alignByBaseline(),
                            fontSize = 14.sp
                        )
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = onClick,
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Star, // need to check if favorite or not
                            contentDescription = "Favorite",
                            tint = Color.Gray
                        )
                    }
                }
            }
        }
    }
}