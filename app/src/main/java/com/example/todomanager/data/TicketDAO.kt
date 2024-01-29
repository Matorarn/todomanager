package com.example.todomanager.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TicketDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ticket: Ticket)

    @Update
    suspend fun update(ticket: Ticket)

    @Delete
    suspend fun delete(ticket: Ticket)

    @Query("SELECT * from tickets WHERE id = :id")
    fun getTicket(id: Int): Flow<Ticket>

    @Query("SELECT * from categories")
    fun getCategories(): Flow<List<Category>>

    @Query("SELECT * FROM tickets WHERE currentRow = 'Backlog' ORDER BY title ASC")
    fun getBacklogTickets(): Flow<List<Ticket>>

    @Query("SELECT * FROM tickets WHERE currentRow = 'ToDo' ORDER BY title ASC")
    fun getToDoTickets(): Flow<List<Ticket>>

    @Query("SELECT * FROM tickets WHERE currentRow = 'Doing' ORDER BY title ASC")
    fun getDoingTickets(): Flow<List<Ticket>>

    @Query("SELECT * FROM tickets WHERE currentRow = 'Done' ORDER BY title ASC")
    fun getDoneTickets(): Flow<List<Ticket>>
}