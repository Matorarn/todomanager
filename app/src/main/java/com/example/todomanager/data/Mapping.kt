package com.example.todomanager.data

import com.example.todomanager.data.category.Category
import com.example.todomanager.data.ticket.Ticket
import com.example.todomanager.room.CategoryDTO
import com.example.todomanager.room.TicketDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal fun TicketDTO.toEntity() = Ticket(
    id = id,
    title = title,
    content = content,
    currentRow = when (currentRow) {
        TicketDTO.RowDTO.BACKLOG -> Ticket.Row.BACKLOG
        TicketDTO.RowDTO.TODO -> Ticket.Row.TODO
        TicketDTO.RowDTO.DOING -> Ticket.Row.DOING
        TicketDTO.RowDTO.DONE -> Ticket.Row.DONE
    },
    categoryId = categoryId,
    dueDate = dueDate,
    doneDate = doneDate,
)

internal fun CategoryDTO.toEntity() = Category(
    id = id,
    title = title,
    emoji = emoji,
    color = color,
)

internal fun Ticket.toDto() = TicketDTO(
    title = title,
    content = content,
    currentRow = when (currentRow) {
        Ticket.Row.BACKLOG -> TicketDTO.RowDTO.BACKLOG
        Ticket.Row.TODO -> TicketDTO.RowDTO.TODO
        Ticket.Row.DOING -> TicketDTO.RowDTO.DOING
        Ticket.Row.DONE -> TicketDTO.RowDTO.DONE
    },
    categoryId = categoryId,
    dueDate = dueDate,
    doneDate = doneDate,
)

internal fun Category.toDto() = CategoryDTO(
    id = id,
    title = title,
    emoji = emoji,
    color = color,
)

internal fun Flow<List<TicketDTO>>.toTicketFlow(): Flow<List<Ticket>> =
    this.map { list -> list.map { it.toEntity() } }