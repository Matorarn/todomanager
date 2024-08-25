package com.example.todomanager.ui.ticketconfig.configelements.picker

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.todomanager.data.ticket.Ticket

@Composable
fun RowPicker(
    modifier: Modifier = Modifier,
    selectedRow: Ticket.Row,
    onSelectRow: (Ticket.Row) -> Unit,
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(8.dp),
    ) {
        Text(
            text = "Status des Tickets",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Ticket.Row.entries.forEach {
                Box(
                    modifier = Modifier
                        .border(
                            BorderStroke(
                                width = if (selectedRow == it) 2.dp else Dp.Hairline,
                                color = MaterialTheme.colorScheme.onSurface,
                            ),
                            shape = RoundedCornerShape(16.dp),
                        )
                        .clip(RoundedCornerShape(16.dp))
                        .clickable(onClick = { onSelectRow(it) })
                        .padding(8.dp),
                ) {
                    Text(
                        text = it.toString().lowercase().replaceFirstChar { char -> char.uppercase() },
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun RowPickerPreview() {
    RowPicker(
        selectedRow = Ticket.Row.BACKLOG,
        onSelectRow = {},
    )
}
