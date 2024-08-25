package com.example.todomanager.ui.ticketconfig.configelements.dialogs.duedate

import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DueDatePickerDialog(
    onDueDateSelect: (LocalDate?) -> Unit,
    onShow: Boolean,
    onDismiss: () -> Unit,
) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = System.currentTimeMillis(),
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis > System.currentTimeMillis() - 86400000
            }
        },
    )
    val dueDate = datePickerState.selectedDateMillis?.let { convertMillisToDate(it) }

    if (onShow) {
        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                Button(onClick = {
                    onDueDateSelect(dueDate)
                    onDismiss()
                }) {
                    Text(text = "Speichern")
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() },
                ) {
                    Text(text = "Abbrechen")
                }
            },
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

private fun convertMillisToDate(millis: Long): LocalDate {
    return Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate()
}

@Preview
@Composable
private fun DueDateDialogPreview() {
    DueDatePickerDialog(
        onDueDateSelect = {},
        onShow = true,
        onDismiss = {},
    )
}