package com.example.todomanager.ui.ticketconfig.configelements.dialogs.row

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.todomanager.data.ticket.Ticket

@Composable
fun RowPickerDialog(
    selectedRow: Ticket.Row,
    onSelectRow: (Ticket.Row) -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(16.dp),
                )
                .padding(16.dp),
        ) {
            RowItem(
                title = Ticket.Row.BACKLOG.toString(),
                isSelected = selectedRow == Ticket.Row.BACKLOG,
                onSelect = { onSelectRow(Ticket.Row.BACKLOG) },
            )
            RowItem(
                title = Ticket.Row.TODO.toString(),
                isSelected = selectedRow == Ticket.Row.TODO,
                onSelect = { onSelectRow(Ticket.Row.TODO) },
            )
            RowItem(
                title = Ticket.Row.DOING.toString(),
                isSelected = selectedRow == Ticket.Row.DOING,
                onSelect = { onSelectRow(Ticket.Row.DOING) },
            )
            RowItem(
                title = Ticket.Row.DONE.toString(),
                isSelected = selectedRow == Ticket.Row.DONE,
                onSelect = { onSelectRow(Ticket.Row.DONE) },
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(onClick = onDismiss) {
                    Text("Abbrechen")
                }
                Button(onClick = {
                    onSelectRow(selectedRow)
                    onDismiss()
                }) {
                    Text("Speichern")
                }
            }
        }
    }
}

@Composable
private fun RowItem(
    title: String,
    isSelected: Boolean,
    onSelect: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onSelect)
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(8.dp),
    ) {
        Text(text = title)
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = if (isSelected) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
private fun RowPickerDialogPreview() {
    RowPickerDialog(
        selectedRow = Ticket.Row.BACKLOG,
        onSelectRow = {},
        onDismiss = {},
    )
}

@Preview
@Composable
private fun RowItemPreview() {
    RowItem(
        title = Ticket.Row.BACKLOG.toString(),
        isSelected = true,
        onSelect = {},
    )
}