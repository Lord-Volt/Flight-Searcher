package com.example.flightsearcher.flight.presentation.flight_search_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun FlightSearchScreen(
    viewModel: FlightSearchViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()

    FlightSearchScreenUi(
        state = state,
        onQueryChange = { newText ->
            coroutineScope.launch {
                viewModel.onAction(FlightSearchAction.OnSearchFieldChange(newText))
            }
        },
        onAirportClick = { airport ->
            coroutineScope.launch {
                viewModel.onAction(FlightSearchAction.OnAirportClick(airport))
            }
        },
        onFavoriteClick = { flight ->
            coroutineScope.launch {
                viewModel.onAction(FlightSearchAction.OnFavoriteClick(flight))
            }
        }
    )
}