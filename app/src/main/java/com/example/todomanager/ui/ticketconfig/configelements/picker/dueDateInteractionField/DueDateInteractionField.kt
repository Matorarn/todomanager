package com.example.todomanager.ui.ticketconfig.configelements.picker.dueDateInteractionField

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun DueDateInteractionField(
    modifier: Modifier = Modifier,
    dueDate: LocalDate?,
    onShowDatePickerDialog: () -> Unit,
    onDeleteDueDateValue: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(8.dp),
    ) {
        var currentState by remember { mutableStateOf<DatePickerState>(DatePickerState.Undefined) }

        Text(
            text = "Deadline",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        when (currentState) {
            is DatePickerState.DueDatePicker -> DueDatePickerTextField(
                dueDate = dueDate,
                onShowDatePickerDialog = onShowDatePickerDialog,
                onDeleteDueDateValue = onDeleteDueDateValue,
                changeCurrentState = { currentState = it },
            )

            is DatePickerState.NoDueDate -> DueDateEmpty(
                modifier = modifier,
                onShowDatePickerDialog = onShowDatePickerDialog,
                changeCurrentState = { currentState = it },
            )

            is DatePickerState.Undefined -> DueDateOptions(
                modifier = modifier,
                onShowDatePickerDialog = onShowDatePickerDialog,
                changeCurrentState = { currentState = it },
            )
        }
    }
}

sealed class DatePickerState {
    data object Undefined : DatePickerState()
    data object DueDatePicker : DatePickerState()
    data object NoDueDate : DatePickerState()
}

@Preview
@Composable
private fun DueDatePickerInteractionFieldPreview() {
    DueDateInteractionField(
        dueDate = LocalDate.now(),
        onShowDatePickerDialog = {},
        onDeleteDueDateValue = {},
    )
}