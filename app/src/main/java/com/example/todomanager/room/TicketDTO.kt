package com.example.todomanager.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.todomanager.data.category.CategoryColors
import java.time.LocalDate

@Entity(
    tableName = "tickets",
    foreignKeys = [
        ForeignKey(
            entity = CategoryDTO::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("categoryId"),
            onDelete = ForeignKey.SET_NULL,
        ),
    ],
)
data class TicketDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val categoryId: Int,
    val title: String,
    val content: String,
    val currentRow: RowDTO,
    val dueDate: LocalDate? = null,
    val doneDate: LocalDate? = null,
) {
    enum class RowDTO { BACKLOG, TODO, DOING, DONE }
}

@Entity(tableName = "categories")
data class CategoryDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val emoji: String,
    val color: CategoryColors,
)
