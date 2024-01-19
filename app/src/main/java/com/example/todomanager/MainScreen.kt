package com.example.todomanager


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todomanager.components.MainScaffold
import com.example.todomanager.components.TicketCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen() {
    val viewModel = koinViewModel<MainViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    MainScaffold(
        mainTitle = "Backlog"
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 8.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TicketCard(
                title = "Waschmittel einkaufen gehen",
                dueDate = "16.04.2024"
            )
            TicketCard(
                title = "Gemüse einkaufen ",
                dueDate = "16.04.2024"
            )
            TicketCard(
                title = "Getränke einkaufen ",
                dueDate = "16.04.2024"
            )
            TicketCard(
                title = "Brötchen einkaufen ",
                dueDate = "16.04.2024"
            )
        }
    }
}