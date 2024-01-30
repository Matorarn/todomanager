package com.example.todomanager.ui.overview

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todomanager.components.MainScaffold
import com.example.todomanager.components.TicketCard
import com.example.todomanager.data.ticket.mockTickets

@Composable
fun OverviewScreen(
    uiState: OverviewState,
    onShowTicketConfig: () -> Unit,
) {
    var selectedState by rememberSaveable { mutableStateOf(State.TODO) }

    MainScaffold(
        mainTitle = when (selectedState) {
            State.BACKLOG -> "Backlog"
            State.TODO -> "To Do"
            State.DOING -> "Doing"
            State.DONE -> "Done"
        },
        selectedState = selectedState,
        onSelect = { selectedState = it },
        onShowTicketConfig = onShowTicketConfig,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Vertical,
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            when (selectedState) {
                State.BACKLOG -> uiState.backlog?.forEach {
                    TicketCard(ticket = it)
                }

                State.TODO -> uiState.toDo?.forEach {
                    TicketCard(ticket = it)
                }

                State.DOING -> uiState.doing?.forEach {
                    TicketCard(ticket = it)
                }

                State.DONE -> uiState.done?.forEach {
                    TicketCard(ticket = it)
                }
            }
        }
    }
}

enum class State {
    BACKLOG, TODO, DOING, DONE
}

@Preview
@Composable
private fun OverviewPreview() {
    OverviewScreen(
        uiState = OverviewState(
            backlog = mockTickets,
            toDo = mockTickets,
            doing = mockTickets,
            done = mockTickets,
        ),
        onShowTicketConfig = {},
    )
}