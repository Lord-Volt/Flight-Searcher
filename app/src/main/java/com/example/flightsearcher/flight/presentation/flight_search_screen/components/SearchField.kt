package com.example.flightsearcher.flight.presentation.flight_search_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.flightsearcher.ui.theme.FlightSearcherTheme
import com.example.flightsearcher.ui.theme.LocalTheme
import com.example.flightsearcher.ui.theme.darkThemeColors
import com.example.flightsearcher.ui.theme.lightThemeColors

@Composable
fun SearchField(
    searchText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val theme = LocalTheme.current
    val shape = RoundedCornerShape(8.dp)
    TextField(
        value = searchText,
        onValueChange = onValueChange,
        placeholder = { Text("Search for airports!") },
        trailingIcon = {
            if(searchText.isNotEmpty()) {
                IconButton(
                    onClick = { onValueChange("") }
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear Search",
                        tint = theme.iconPrimary
                    )
                }
            }
        },
        singleLine = true,
        shape = shape,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = theme.surfaceLight,
            unfocusedContainerColor = theme.surfaceLight,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = theme.iconPrimary
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                width = 1.dp,
                color = theme.borderPrimary,
                shape = shape
            )
    )
}

@PreviewLightDark
@Composable
fun FlightSearchScreenPreview() {
    FlightSearcherTheme {
        val themeColors = if(isSystemInDarkTheme()) darkThemeColors else lightThemeColors
        CompositionLocalProvider(LocalTheme provides themeColors) {
            SearchField(
                searchText = "JFK",
                onValueChange = {}
            )
        }
    }
}