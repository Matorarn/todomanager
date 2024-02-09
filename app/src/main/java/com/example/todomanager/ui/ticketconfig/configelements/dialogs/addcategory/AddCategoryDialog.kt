package com.example.todomanager.ui.ticketconfig.configelements.dialogs.addcategory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.todomanager.data.category.Category
import com.example.todomanager.data.category.CategoryColors

@Composable
fun AddCategoryDialog(
    onSave: (Category) -> Unit,
    onDismiss: () -> Unit,
) {
    var title by rememberSaveable { mutableStateOf("") }
    var emoji by rememberSaveable { mutableStateOf("\uD83D\uDE00") }
    var color by rememberSaveable { mutableStateOf(CategoryColors.RED) }

    var showEmojiPicker by rememberSaveable { mutableStateOf(false) }
    if (showEmojiPicker) {
        EmojiPickerDialog(
            onEmojiChange = { emoji = it },
            onDismiss = { showEmojiPicker = false },
        )
    }

    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(16.dp),
                )
                .padding(8.dp),
        ) {
            Text(text = "Kategorie erstellen")
            Text(text = "Titel")
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = { title = it },
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Emoji")
            EmojiPicker(
                emoji = emoji,
                backGroundColor = color,
                onClick = { showEmojiPicker = true },
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Farbe")
            ColorPicker(
                selectedColor = color,
                onSelect = { color = it },
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(
                    onClick = onDismiss,
                ) {
                    Text(text = "Abbrechen")
                }
                Button(
                    onClick = {
                        onSave(
                            Category(
                                title = title,
                                emoji = emoji,
                                color = color,
                            ),
                        )
                        onDismiss()
                    },
                ) {
                    Text(text = "Speichern")
                }
            }
        }
    }
}

@Preview
@Composable
private fun AddCategoryDialogPreview() {
    AddCategoryDialog(
        onSave = {},
        onDismiss = {},
    )
}