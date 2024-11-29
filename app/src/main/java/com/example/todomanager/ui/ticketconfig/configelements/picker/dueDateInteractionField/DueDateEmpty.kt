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
fun DueDateEmpty(
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
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
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
            Text("Keine Frist gewählt. Hier Frist wählen!")
        }
    }
}

@Preview
@Composable
private fun NoDueDatePreview() {
    DueDateEmpty(
        onShowDatePickerDialog = {},
        changeCurrentState = {},
    )
}