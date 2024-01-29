package com.example.todomanager.data

import kotlinx.coroutines.flow.Flow

class OfflineTicketsRepository(private val ticketDAO: TicketDAO) : TicketRepository {
    override fun getBacklogTicketsStream(): Flow<List<Ticket>> = ticketDAO.getBacklogTickets()

    override fun getToDoTicketsStream(): Flow<List<Ticket>> = ticketDAO.getToDoTickets()

    override fun getDoingTicketsStream(): Flow<List<Ticket>> = ticketDAO.getDoingTickets()

    override fun getDoneTicketsStream(): Flow<List<Ticket>> = ticketDAO.getDoneTickets()

    override fun getTicketStream(id: Int): Flow<Ticket?> = ticketDAO.getTicket(id)

    override fun getCategoriesStream(): Flow<List<Category?>> = ticketDAO.getCategories()

    override suspend fun insertTicket(ticket: Ticket) = ticketDAO.insert(ticket)

    override suspend fun deleteTicket(ticket: Ticket) = ticketDAO.delete(ticket)

    override suspend fun updateTicket(ticket: Ticket) = ticketDAO.update(ticket)
}