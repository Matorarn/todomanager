package com.example.todomanager.ui.ticketconfig.configelements.textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todomanager.ui.components.ClearTextButton

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

@Preview
@Composable
private fun TitleTextFieldPreview() {
    TitleTextField(
        value = "Einkaufen",
        onValueChange = {},
    )
}