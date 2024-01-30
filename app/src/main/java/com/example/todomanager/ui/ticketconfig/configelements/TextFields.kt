package com.example.todomanager.ui.ticketconfig.configelements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp

@Composable
fun TitleTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Titel") },
        trailingIcon = (@Composable { ClearTextButton(onClick = { onValueChange("") }) }),
        singleLine = true,
        shape = CircleShape,
        isError = false,
    )
}

@Composable
fun ContentTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Beschreibung") },
        trailingIcon = (@Composable { ClearTextButton(onClick = { onValueChange("") }) }),
        singleLine = false,
        shape = CircleShape,
        isError = false,
    )
}

@Composable
private fun ClearTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = CircleShape,
                ),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
private fun TitleTextFieldPreview() {
    TitleTextField(
        value = "Einkaufen",
        onValueChange = {},
    )
}

@Preview
@Composable
private fun ContentTextFieldPreview() {
    ContentTextField(
        value = LoremIpsum(15).toString(),
        onValueChange = {},
    )
}