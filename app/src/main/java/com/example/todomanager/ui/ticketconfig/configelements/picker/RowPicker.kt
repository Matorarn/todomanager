package com.example.todomanager.ui.ticketconfig.configelements.picker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todomanager.data.ticket.Ticket

@Composable
fun RowPicker(
    modifier: Modifier = Modifier,
    row: Ticket.Row,
    onShowRowPickerDialog: () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 2.dp)
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(8.dp),
    ) {
        Text(text = "Status des Tickets")
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .clickable(onClick = onShowRowPickerDialog)
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = row.toString())
            Spacer(Modifier.weight(1f))
            Icon(imageVector = Icons.Default.Create, contentDescription = null)
        }
    }
}

@Preview
@Composable
private fun RowPickerPreview() {
    RowPicker(
        row = Ticket.Row.BACKLOG,
        onShowRowPickerDialog = {},
    )
}
