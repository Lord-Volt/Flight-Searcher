package com.example.flightsearcher.flight.presentation.flight_search_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightsearcher.flight.presentation.model.FlightUi
import com.example.flightsearcher.ui.theme.FlightSearcherTheme
import com.example.flightsearcher.ui.theme.LocalTheme
import com.example.flightsearcher.ui.theme.darkThemeColors
import com.example.flightsearcher.ui.theme.lightThemeColors

@Composable
fun FlightListItem(
    flight: FlightUi,
    onClick: () -> Unit
) {
    val theme = LocalTheme.current
    val shape = RoundedCornerShape(8.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = theme.surfaceLight, shape = shape)
            .border(
                width = 1.dp,
                color = theme.borderPrimary,
                shape = shape
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        ) {
            Text(
                text = "Depart",
                fontWeight = FontWeight.SemiBold,
                color = theme.textPrimary,
                fontSize = 16.sp
            )
            Row {
                Text(
                    text = flight.departureAirportCode + " ",
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace,
                    color = theme.textPrimary,
                    fontSize = 14.sp
                )
                Text(
                    text = flight.departureAirportName, // limit if too long
                    color = theme.textPrimary,
                    fontSize = 14.sp
                )
            }
            Text(
                text = "Arrive",
                fontWeight = FontWeight.SemiBold,
                color = theme.textPrimary,
                fontSize = 16.sp
            )
            Row {
                Text(
                    text = flight.arrivalAirportCode + " ",
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace,
                    color = theme.textPrimary,
                    fontSize = 14.sp
                )
                Text(
                    text = flight.arrivalAirportName, // limit if too long
                    color = theme.textPrimary,
                    fontSize = 14.sp
                )
            }
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = onClick,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Star, // need to check if favorite or not
                    contentDescription = "Favorite",
                    tint = theme.buttonPrimary
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun FlightListItemPreview() {
    val themeColors = if(isSystemInDarkTheme()) darkThemeColors else lightThemeColors
    CompositionLocalProvider(LocalTheme provides themeColors) {
        FlightSearcherTheme {
            FlightListItem(
                flight = FlightUi(
                    departureAirportCode = "JFK",
                    departureAirportName = "John F. Kennedy International Airport",
                    arrivalAirportCode = "LAX",
                    arrivalAirportName = "Los Angeles International Airport"
                ),
                onClick = {}
            )
        }
    }
}