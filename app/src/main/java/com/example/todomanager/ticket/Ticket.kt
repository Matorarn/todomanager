package com.example.todomanager.ticket

import androidx.compose.ui.graphics.Color
import java.util.Date

data class Ticket(
    val uuid: Int,
    val title: String,
    val content: String?,
    val category: Category?,
    val currentRow: Row,
    val dueDate: Date?,
    val doneDate: Date?
) {
    class Category (
        val uuid: Int,
        val title: String,
        val color: Color,
    )
    enum class Row { BACKLOG, TODO, DOING, DONE }
}