package com.example.todomanager.ui.ticketconfig.configelements.picker

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun DueDatePickerTextField(
    modifier: Modifier = Modifier,
    dueDate: LocalDate?,
    onShowDatePickerDialog: () -> Unit,
    onDeleteDueDateValue: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(8.dp),
    ) {
        Text(
            text = "Deadline",
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .border(
                    BorderStroke(
                        width = Dp.Hairline,
                        color = Color.Black,
                    ),
                    shape = RoundedCornerShape(16.dp),
                )
                .clip(RoundedCornerShape(16.dp))
                .clickable(onClick = onShowDatePickerDialog)
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            // TODO Add Date Formatter
            Text(
                text = dueDate.toString(),
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.labelLarge,
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.clickable(onClick = onDeleteDueDateValue),
                imageVector = Icons.Default.Delete,
                contentDescription = null,
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
    )
}