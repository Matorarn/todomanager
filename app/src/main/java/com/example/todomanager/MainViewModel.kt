package com.example.todomanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todomanager.data.Ticket
import com.example.todomanager.data.TicketRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import java.time.LocalDate

data class MainState(
    val backlog: List<Ticket>? = emptyList(),
    val toDo: List<Ticket>? = emptyList(),
    val doing: List<Ticket>? = emptyList(),
    val done: List<Ticket>? = emptyList(),
)

class MainViewModel(
    private val ticketRepo: TicketRepository,
) : ViewModel() {

    val uiState: StateFlow<MainState> = combine(
        ticketRepo.getBacklogTicketsStream(),
        ticketRepo.getToDoTicketsStream(),
        ticketRepo.getDoingTicketsStream(),
        ticketRepo.getDoneTicketsStream(),
    ) { backlog, toDo, doing, done ->
        MainState(
            backlog = backlog,
            toDo = toDo,
            doing = doing,
            done = done,
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, MainState())

    data class TicketUiState(
        val ticketDetails: TicketDetails = TicketDetails(),
        val isEntryValid: Boolean = false,
    )

    data class TicketDetails(
        val id: Int = 0,
        val category: Int = 0,
        val title: String = "",
        val content: String? = "",
        val currentRow: Ticket.Row = Ticket.Row.DOING,
        val dueDate: LocalDate? = null,
        val doneDate: LocalDate? = null,
    )

    fun TicketDetails.toTicket(): Ticket = Ticket(
        id = id,
        category = category,
        title = title,
        content = content ?: "",
        currentRow = currentRow,
        dueDate = dueDate,
        doneDate = doneDate,
    )

    fun Ticket.toTicketUiState(isEntryValid: Boolean = false): TicketUiState = TicketUiState(
        ticketDetails = this.toTicketDetails(),
        isEntryValid = isEntryValid,
    )

    fun Ticket.toTicketDetails(): TicketDetails = TicketDetails(
        id = id,
        category = category,
        title = title,
        content = content,
        currentRow = currentRow,
        dueDate = dueDate,
        doneDate = doneDate,
    )
}