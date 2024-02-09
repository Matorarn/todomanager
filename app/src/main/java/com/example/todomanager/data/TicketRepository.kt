package com.example.todomanager.data

import com.example.todomanager.data.category.Category
import com.example.todomanager.data.ticket.Ticket
import com.example.todomanager.room.TicketDAO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TicketRepository(
    private val ticketDAO: TicketDAO,
) {
    fun getBacklogTicketsStream(): Flow<List<Ticket>> {
        val backlogTickets = ticketDAO.getBacklogTickets()
        return backlogTickets.toTicketFlow()
    }

    fun getToDoTicketsStream(): Flow<List<Ticket>> {
        val toDoTickets = ticketDAO.getToDoTickets()
        return toDoTickets.toTicketFlow()
    }

    fun getDoingTicketsStream(): Flow<List<Ticket>> {
        val doingTickets = ticketDAO.getDoingTickets()
        return doingTickets.toTicketFlow()
    }

    fun getDoneTicketsStream(): Flow<List<Ticket>> {
        val doneTickets = ticketDAO.getDoneTickets()
        return doneTickets.toTicketFlow()
    }

    fun getTicketStream(id: Int): Flow<Ticket?> {
        val ticket = ticketDAO.getTicket(id)
        return ticket.map { it.toEntity() }
    }

    fun getCategoriesStream(): Flow<List<Category?>> {
        val categories = ticketDAO.getCategories()
        return categories.map { list -> list.map { ticket -> ticket.toEntity() } }
    }

    suspend fun insertCategory(category: Category) {
        ticketDAO.insertCategory(category.toDto())
    }

    suspend fun insertTicket(ticket: Ticket) {
        ticketDAO.insertTicket(ticket.toDto())
    }

    suspend fun deleteTicket(ticket: Ticket) {
        ticketDAO.deleteTicket(ticket.toDto())
    }

    suspend fun updateTicket(ticket: Ticket) {
        ticketDAO.updateTicket(ticket.toDto())
    }
}