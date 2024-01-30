package com.example.todomanager.data.ticket

import java.time.LocalDate

data class Ticket(
    val id: Int = 0,
    val title: String,
    val content: String,
    val currentRow: Row,
    val categoryId: Int,
    val dueDate: LocalDate? = null,
    val doneDate: LocalDate? = null,
) {
    enum class Row { BACKLOG, TODO, DOING, DONE }
}
