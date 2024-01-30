package com.example.todomanager.ui.overview

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel

object OverviewNavigation {
    const val route = "overview"
}

fun NavGraphBuilder.overviewScreen(
    showTicketConfig: () -> Unit,
) {
    composable(OverviewNavigation.route) {
        val viewModel = koinViewModel<OverviewViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        OverviewScreen(
            uiState = uiState,
            onShowTicketConfig = showTicketConfig,
        )
    }
}