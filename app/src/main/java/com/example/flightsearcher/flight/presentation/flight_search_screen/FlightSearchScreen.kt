package com.example.flightsearcher.flight.presentation.flight_search_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun FlightSearchScreen(
    viewModel: FlightSearchViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    FlightSearchScreenUi(
        state = state,
        onQueryChange = { newText ->
            viewModel.onAction(FlightSearchAction.OnSearchFieldChange(newText))
        },
        onAirportClick = { airport ->
            viewModel.onAction(FlightSearchAction.OnAirportClick(airport))
        },
        onFavoriteClick = { flight ->
            viewModel.onAction(FlightSearchAction.OnFavoriteClick(flight))
        }
    )
}