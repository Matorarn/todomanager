package com.example.todomanager

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todomanager.components.MainScaffold
import com.example.todomanager.components.TicketCard
import org.koin.androidx.compose.koinViewModel

enum class State {
    BACKLOG, TODO, DOING, DONE
}

@Composable
fun MainScreen() {
    val viewModel = koinViewModel<MainViewModel>()
    val uiState by viewModel.uiState.collectAsState()
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
                    TicketCard(title = it.title, dueDate = it.dueDate.toString())
                }

                State.TODO -> uiState.toDo?.forEach {
                    TicketCard(title = it.title, dueDate = it.dueDate.toString())
                }

                State.DOING -> uiState.doing?.forEach {
                    TicketCard(title = it.title, dueDate = it.dueDate.toString())
                }

                State.DONE -> uiState.done?.forEach {
                    TicketCard(title = it.title, dueDate = it.dueDate.toString())
                }
            }
        }
    }
}