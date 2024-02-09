package com.example.todomanager.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todomanager.data.LocalDateConverter

@Database(
    entities = [TicketDTO::class, CategoryDTO::class],
    version = 4,
    exportSchema = false,
)
@TypeConverters(
    LocalDateConverter::class,
)
abstract class TicketDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDAO
}
