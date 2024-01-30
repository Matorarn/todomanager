package com.example.todomanager

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.todomanager.ui.overview.OverviewNavigation
import com.example.todomanager.ui.overview.overviewScreen
import com.example.todomanager.ui.ticketconfig.showTicketConfig
import com.example.todomanager.ui.ticketconfig.ticketConfigScreen

@Composable
fun MainScreen() {
    val mainController = rememberNavController()

    NavHost(
        navController = mainController,
        startDestination = OverviewNavigation.route,
    ) {
        overviewScreen(showTicketConfig = mainController::showTicketConfig)
        ticketConfigScreen(navigateUp = mainController::navigateUp)
    }
}