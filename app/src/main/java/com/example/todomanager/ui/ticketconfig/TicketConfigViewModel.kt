package com.example.todomanager.ui.ticketconfig

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todomanager.data.TicketRepository
import com.example.todomanager.data.category.Category
import com.example.todomanager.data.ticket.Ticket
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class TicketConfigState(
    val categoryList: List<Category?> = emptyList(),
)

class TicketConfigViewModel(
    private val ticketRepo: TicketRepository,
) : ViewModel() {
    val uiState: StateFlow<TicketConfigState> = ticketRepo.getCategoriesStream().map {
        TicketConfigState(categoryList = it)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, TicketConfigState())

    fun onSaveTicket(ticket: Ticket) {
        viewModelScope.launch {
            ticketRepo.insertTicket(ticket)
        }
    }

    fun onSaveCategory(category: Category) {
        viewModelScope.launch {
            ticketRepo.insertCategory(category)
        }
    }
}