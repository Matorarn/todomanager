package com.example.todomanager.data

import androidx.annotation.ColorInt
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "tickets",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("category"),
            onDelete = ForeignKey.CASCADE,
        ),
    ],
)
data class Ticket(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val category: Int,
    val title: String,
    val content: String,
    val currentRow: Row,
    val dueDate: LocalDate? = null,
    val doneDate: LocalDate? = null,
) {
    enum class Row { BACKLOG, TODO, DOING, DONE }
}

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val emoji: String,
    @ColorInt val color: Int,
)
