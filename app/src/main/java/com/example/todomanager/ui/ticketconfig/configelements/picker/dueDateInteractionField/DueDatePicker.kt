package com.example.todomanager.ui.ticketconfig.configelements.picker.dueDateInteractionField

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DueDatePickerTextField(
    modifier: Modifier = Modifier,
    dueDate: LocalDate?,
    onShowDatePickerDialog: () -> Unit,
    onDeleteDueDateValue: () -> Unit,
    changeCurrentState: (DatePickerState) -> Unit,
) {
    Row(
        modifier = modifier
            .border(
                BorderStroke(
                    width = Dp.Hairline,
                    color = MaterialTheme.colorScheme.onSurface,
                ),
                shape = RoundedCornerShape(16.dp),
            )
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = MaterialTheme.colorScheme.surface,
            )
            .clickable(onClick = onShowDatePickerDialog)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = dueDate?.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) ?: "",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelLarge,
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {
                onDeleteDueDateValue()
                changeCurrentState(DatePickerState.NoDueDate)
            },
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Preview
@Composable
private fun DueDatePickerLabelPreview() {
    DueDatePickerTextField(
        dueDate = LocalDate.now(),
        onShowDatePickerDialog = {},
        onDeleteDueDateValue = {},
        changeCurrentState = {},
    )
}