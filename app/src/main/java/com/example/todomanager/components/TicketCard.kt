package com.example.todomanager.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todomanager.data.ticket.Ticket
import com.example.todomanager.data.ticket.mockTicket

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketCard(
    ticket: Ticket,
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { /*TODO*/ },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp,
        ),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = ticket.title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Divider(thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CategoryIcon(Icons.Default.Call)
                // TODO Add content tab/visibility
                CategoryIcon(icon = Icons.Default.Menu)
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        modifier = Modifier
                            // .padding(8.dp)
                            .align(Alignment.CenterHorizontally),
                        text = ticket.dueDate.toString(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Composable
private fun CategoryIcon(
    icon: ImageVector,
) {
    Icon(
        modifier = Modifier.padding(8.dp),
        imageVector = icon,
        contentDescription = null,
    )
}

@Preview
@Composable
private fun Preview() {
    TicketCard(
        ticket = mockTicket,
    )
}