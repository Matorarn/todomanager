package com.example.todomanager.room

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
    suspend fun insertTicket(ticket: TicketDTO)

    @Update
    suspend fun updateTicket(ticket: TicketDTO)

    @Delete
    suspend fun deleteTicket(ticket: TicketDTO)

    @Query("SELECT * from tickets WHERE id = :id")
    fun getTicket(id: Int): Flow<TicketDTO>

    @Query("SELECT * from categories")
    fun getCategories(): Flow<List<CategoryDTO>>

    @Insert
    suspend fun insertCategory(category: CategoryDTO)

    @Query("SELECT * FROM tickets WHERE currentRow = 'Backlog' ORDER BY title ASC")
    fun getBacklogTickets(): Flow<List<TicketDTO>>

    @Query("SELECT * FROM tickets WHERE currentRow = 'ToDo' ORDER BY title ASC")
    fun getToDoTickets(): Flow<List<TicketDTO>>

    @Query("SELECT * FROM tickets WHERE currentRow = 'Doing' ORDER BY title ASC")
    fun getDoingTickets(): Flow<List<TicketDTO>>

    @Query("SELECT * FROM tickets WHERE currentRow = 'Done' ORDER BY title ASC")
    fun getDoneTickets(): Flow<List<TicketDTO>>
}