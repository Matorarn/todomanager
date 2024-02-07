package com.example.todomanager.ui.ticketconfig

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todomanager.data.category.Category
import com.example.todomanager.data.category.mockCategories
import com.example.todomanager.data.ticket.Ticket
import com.example.todomanager.ui.ticketconfig.configelements.CategorySwitch
import com.example.todomanager.ui.ticketconfig.configelements.ContentTextField
import com.example.todomanager.ui.ticketconfig.configelements.TitleTextField
import com.example.todomanager.ui.ticketconfig.configelements.picker.DueDatePickerDialog
import com.example.todomanager.ui.ticketconfig.configelements.picker.DueDatePickerTextField
import com.example.todomanager.ui.ticketconfig.configelements.picker.RowPicker
import java.time.LocalDate

@Composable
fun TicketConfigScreen(
    uiState: TicketConfigState,
    onQuit: () -> Unit,
    onSave: (ticket: Ticket) -> Unit,
) {
    var title by rememberSaveable { mutableStateOf("") }
    var content by rememberSaveable { mutableStateOf("") }
    var category by remember {
        mutableStateOf(
            Category(
                id = 0,
                title = "",
                emoji = "",
                color = Color.Cyan.value.toInt(),
            ),
        )
    }
    var dueDate: LocalDate? by rememberSaveable { mutableStateOf(null) }
    var currentRow by rememberSaveable { mutableStateOf("") }

    var showDueDatePicker by remember { mutableStateOf(false) }
    DueDatePickerDialog(
        onDueDateSelect = { dueDate = it },
        onShow = showDueDatePicker,
        onDismiss = { showDueDatePicker = false },
    )

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        TitleTextField(
            value = title,
            onValueChange = { title = it },
        )
        ContentTextField(
            value = content,
            onValueChange = { content = it },
        )
        CategorySwitch(
            categoryList = uiState.categoryList,
            selectedCategory = category,
        ) { category = it }
        DueDatePickerTextField(
            dueDate = dueDate,
            onShowDatePickerDialog = { showDueDatePicker = true },
            onDeleteDueDateValue = { dueDate = null }
        )
        RowPicker(
            row = currentRow,
            onRowChange = { currentRow = it },
        )
        TextButton(
            onClick = {
                // TODO Check if all inputs are viable
                onSave(
                    Ticket(
                        title = title,
                        content = content,
                        categoryId = category.id,
                        currentRow = Ticket.Row.DOING,
                        dueDate = dueDate,
                        doneDate = null,
                    ),
                )
            },
        ) {
            Text(text = "Eingaben speichern")
        }
        TextButton(onClick = onQuit) {
            Text(text = "Abbrechen")
        }
    }
}

@Preview
@Composable
private fun TicketConfigPreview() {
    TicketConfigScreen(
        uiState = TicketConfigState(
            categoryList = mockCategories,
        ),
        onQuit = {},
        onSave = {},
    )
}