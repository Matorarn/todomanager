package com.example.todomanager.ui.ticketconfig.configelements.picker.dueDateInteractionField

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Composable
fun DueDateOptions(
    modifier: Modifier = Modifier,
    onShowDatePickerDialog: () -> Unit,
    changeCurrentState: (DatePickerState) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
            ),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextButton(
            onClick = {
                onShowDatePickerDialog()
                changeCurrentState(DatePickerState.DueDatePicker)
            },
            border = BorderStroke(
                width = Dp.Hairline,
                color = Color.Black,
            ),
        ) {
            Text("Datum wählen")
        }
        TextButton(
            onClick = {
                changeCurrentState(DatePickerState.NoDueDate)
            },
            border = BorderStroke(
                width = Dp.Hairline,
                color = Color.Black,
            ),
        ) {
            Text("Keine Deadline")
        }
    }
}

@Preview
@Composable
private fun DueDateOptionsPreview() {
    DueDateOptions(
        onShowDatePickerDialog = {},
        changeCurrentState = {},
    )
}