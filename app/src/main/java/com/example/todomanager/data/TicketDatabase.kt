package com.example.todomanager.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Ticket::class, Category::class],
    version = 2,
    exportSchema = false,
)
@TypeConverters(
    LocalDateConverter::class,
)
abstract class TicketDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDAO
}
