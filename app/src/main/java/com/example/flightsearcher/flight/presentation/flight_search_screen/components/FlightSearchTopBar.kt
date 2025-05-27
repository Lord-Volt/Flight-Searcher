package com.example.flightsearcher.flight.presentation.flight_search_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightsearcher.ui.theme.FlightSearcherTheme
import com.example.flightsearcher.ui.theme.LocalTheme
import com.example.flightsearcher.ui.theme.darkThemeColors
import com.example.flightsearcher.ui.theme.lightThemeColors

@Composable
fun FlightSearchTopBar(
    modifier: Modifier = Modifier
) {
    val theme = LocalTheme.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = theme.buttonPrimary
            )
            .padding(16.dp)
    ) {
        Text(
            text = "Flight Searcher",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@PreviewLightDark
@Composable
fun FlightSearchTopBarPreview() {
    FlightSearcherTheme {
        val themeColors = if(isSystemInDarkTheme()) darkThemeColors else lightThemeColors
        CompositionLocalProvider(LocalTheme provides themeColors) {
            FlightSearchTopBar()
        }
    }
}