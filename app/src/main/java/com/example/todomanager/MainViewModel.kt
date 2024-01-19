package com.example.todomanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todomanager.ticket.Ticket
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainState(
    val backlog: List<Ticket>? = emptyList(),
    val toDo: List<Ticket>? = emptyList(),
    val doing: List<Ticket>? = emptyList(),
    val done: List<Ticket>? = emptyList(),
)

class MainViewModel(
    //private val ticketRepo: TicketRespository
) : ViewModel() {
    private val _uistate = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState> = _uistate.asStateFlow()
}