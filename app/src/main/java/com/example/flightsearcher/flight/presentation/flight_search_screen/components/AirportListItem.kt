package com.example.flightsearcher.flight.presentation.flight_search_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.flightsearcher.flight.presentation.model.AirportUi
import com.example.flightsearcher.ui.theme.FlightSearcherTheme
import com.example.flightsearcher.ui.theme.LocalTheme
import com.example.flightsearcher.ui.theme.darkThemeColors
import com.example.flightsearcher.ui.theme.lightThemeColors

@Composable
fun AirportListItem(
    airport: AirportUi,
    onClick: () -> Unit
) {
    val theme = LocalTheme.current
    val shape = RoundedCornerShape(8.dp)
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = theme.surfaceLight, shape = shape)
            .border(
                width = 1.dp,
                color = theme.borderPrimary,
                shape = shape
            )
            .clickable(onClick = onClick)
            .padding(6.dp)
    ) {
        Text(
            text = airport.airportCode,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            color = theme.textPrimary,
            fontSize = 14.sp
        )
        Text(
            text = airport.airportName,
            modifier = Modifier.alignByBaseline(),
            color = theme.textPrimary,
            fontSize = 14.sp
        )
    }
}

@PreviewLightDark
@Composable
private fun AirportListItemPreview() {

    val themeColors = if(isSystemInDarkTheme()) darkThemeColors else lightThemeColors
    CompositionLocalProvider(LocalTheme provides themeColors) {
        FlightSearcherTheme {
            AirportListItem(
                airport = AirportUi(
                    airportCode = "JFK",
                    airportName = "John F. Kennedy International Airport"
                ),
                onClick = {}
            ) 
        }
    }
}