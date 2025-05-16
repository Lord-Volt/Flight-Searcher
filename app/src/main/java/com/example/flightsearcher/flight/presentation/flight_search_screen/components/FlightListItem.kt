package com.example.flightsearcher.flight.presentation.flight_search_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightsearcher.flight.presentation.model.FlightUi

@Composable
fun FlightListItem(
    flight: FlightUi,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(4.dp)
    ) {
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
                    text = flight.departureAirportCode + " ",
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
                    text = flight.arrivalAirportCode + " ",
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