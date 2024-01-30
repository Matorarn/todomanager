package com.example.todomanager.ui.ticketconfig.configelements

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DueDatePicker(
    dueDate: String,
    onDueDateChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier,
        value = dueDate,
        onValueChange = onDueDateChange,
        label = { Text("Deadline") },
    )
}

@Composable
fun RowPicker(
    row: String,
    onRowChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier,
        value = row,
        onValueChange = onRowChange,
        label = { Text("Status des Tickets") },
    )
}

@Preview
@Composable
private fun RowPickerPreview() {
    RowPicker(
        row = "Backlog",
        onRowChange = {},
    )
}

@Preview
@Composable
private fun DueDatePickerPreview() {
    DueDatePicker(
        dueDate = "Backlog",
        onDueDateChange = {},
    )
}