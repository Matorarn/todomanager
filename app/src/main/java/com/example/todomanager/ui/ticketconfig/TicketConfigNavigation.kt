package com.example.todomanager.ui.ticketconfig

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel

object TicketConfigNavigation {
    const val route = "ticketConfig"
}

fun NavGraphBuilder.ticketConfigScreen(
    navigateUp: () -> Unit,
) {
    composable(TicketConfigNavigation.route) {
        val viewModel = koinViewModel<TicketConfigViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        TicketConfigScreen(
            uiState = uiState,
            onQuit = navigateUp,
            onSave = viewModel::onSave,

        )
    }
}

fun NavController.showTicketConfig() {
    navigate(TicketConfigNavigation.route)
}