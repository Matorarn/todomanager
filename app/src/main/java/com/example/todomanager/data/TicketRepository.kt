package com.example.todomanager.data

import kotlinx.coroutines.flow.Flow

interface TicketRepository {
    fun getBacklogTicketsStream(): Flow<List<Ticket>>

    fun getToDoTicketsStream(): Flow<List<Ticket>>

    fun getDoingTicketsStream(): Flow<List<Ticket>>

    fun getDoneTicketsStream(): Flow<List<Ticket>>

    fun getTicketStream(id: Int): Flow<Ticket?>

    fun getCategoriesStream(): Flow<List<Category?>>

    suspend fun insertTicket(ticket: Ticket)

    suspend fun deleteTicket(ticket: Ticket)

    suspend fun updateTicket(ticket: Ticket)
}