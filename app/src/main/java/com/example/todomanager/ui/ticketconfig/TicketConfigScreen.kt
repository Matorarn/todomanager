package com.example.todomanager.ui.ticketconfig

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todomanager.data.category.Category
import com.example.todomanager.data.category.CategoryColors
import com.example.todomanager.data.category.mockCategories
import com.example.todomanager.data.ticket.Ticket
import com.example.todomanager.ui.ticketconfig.configelements.category.CategorySwitch
import com.example.todomanager.ui.ticketconfig.configelements.dialogs.addcategory.AddCategoryDialog
import com.example.todomanager.ui.ticketconfig.configelements.dialogs.duedate.DueDatePickerDialog
import com.example.todomanager.ui.ticketconfig.configelements.dialogs.row.RowPickerDialog
import com.example.todomanager.ui.ticketconfig.configelements.picker.DueDatePickerTextField
import com.example.todomanager.ui.ticketconfig.configelements.picker.RowPicker
import com.example.todomanager.ui.ticketconfig.configelements.textfields.ContentTextField
import com.example.todomanager.ui.ticketconfig.configelements.textfields.TitleTextField
import java.time.LocalDate

@Composable
fun TicketConfigScreen(
    uiState: TicketConfigState,
    onQuit: () -> Unit,
    onSaveTicket: (Ticket) -> Unit,
    onSaveCategory: (Category) -> Unit,
) {
    var title by rememberSaveable { mutableStateOf("") }
    var content by rememberSaveable { mutableStateOf("") }
    var category by remember {
        mutableStateOf(
            Category(
                id = 0,
                title = "",
                emoji = "",
                color = CategoryColors.RED,
            ),
        )
    }
    var dueDate: LocalDate? by rememberSaveable { mutableStateOf(null) }
    var currentRow by rememberSaveable { mutableStateOf(Ticket.Row.BACKLOG) }

    var showRowPickerDialog by remember { mutableStateOf(false) }
    if (showRowPickerDialog) {
        RowPickerDialog(
            selectedRow = currentRow,
            onSelectRow = { currentRow = it },
            onDismiss = { showRowPickerDialog = false },
        )
    }

    var showDueDatePicker by remember { mutableStateOf(false) }
    DueDatePickerDialog(
        onDueDateSelect = { dueDate = it },
        onShow = showDueDatePicker,
        onDismiss = { showDueDatePicker = false },
    )

    var showAddCategoryDialog by remember { mutableStateOf(false) }
    if (showAddCategoryDialog) {
        AddCategoryDialog(
            onSave = onSaveCategory,
            onDismiss = { showAddCategoryDialog = false },
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
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
            onSelectCategory = { category = it },
            showAddCategoryDialog = { showAddCategoryDialog = true },
        )
        DueDatePickerTextField(
            dueDate = dueDate,
            onShowDatePickerDialog = { showDueDatePicker = true },
            onDeleteDueDateValue = { dueDate = null },
        )
        RowPicker(
            row = currentRow,
            onShowRowPickerDialog = { showRowPickerDialog = true },
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(
                onClick = onQuit,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                ),
            ) {
                Text(text = "Abbrechen")
            }
            Button(
                onClick = {
                    // TODO Check if all inputs are viable
                    onSaveTicket(
                        Ticket(
                            title = title,
                            content = content,
                            categoryId = category.id,
                            currentRow = currentRow,
                            dueDate = dueDate,
                            doneDate = null,
                        ),
                    )
                    onQuit()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            ) {
                Text(text = "Eingaben speichern")
            }
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
        onSaveTicket = {},
        onSaveCategory = {},
    )
}