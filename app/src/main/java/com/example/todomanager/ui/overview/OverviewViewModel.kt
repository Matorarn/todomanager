package com.example.todomanager.ui.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todomanager.data.TicketRepository
import com.example.todomanager.data.ticket.Ticket
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

data class OverviewState(
    val backlog: List<Ticket>? = emptyList(),
    val toDo: List<Ticket>? = emptyList(),
    val doing: List<Ticket>? = emptyList(),
    val done: List<Ticket>? = emptyList(),
)

class OverviewViewModel(
    private val ticketRepo: TicketRepository,
) : ViewModel() {

    val uiState: StateFlow<OverviewState> = combine(
        ticketRepo.getBacklogTicketsStream(),
        ticketRepo.getToDoTicketsStream(),
        ticketRepo.getDoingTicketsStream(),
        ticketRepo.getDoneTicketsStream(),
    ) { backlog, toDo, doing, done ->
        OverviewState(
            backlog = backlog,
            toDo = toDo,
            doing = doing,
            done = done,
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, OverviewState())
}