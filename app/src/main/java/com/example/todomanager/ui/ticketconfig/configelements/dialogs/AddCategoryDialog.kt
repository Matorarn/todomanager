package com.example.todomanager.ui.ticketconfig.configelements.dialogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.toColorInt
import androidx.emoji2.emojipicker.EmojiPickerView
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
                Button(onClick = {
                    onSave(
                        Category(
                            title = title,
                            emoji = emoji,
                            color = color,
                        ),
                    )
                    onDismiss()
                }) {
                    Text(text = "Speichern")
                }
            }
        }
    }
}

@Composable
private fun ColorPicker(
    selectedColor: CategoryColors?,
    onSelect: (CategoryColors) -> Unit,
) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .border(
                border = ButtonDefaults.outlinedButtonBorder,
                shape = ButtonDefaults.outlinedShape,
            ),
    ) {
        CategoryColors.entries.forEachIndexed { _, categoryColors ->
            ColorItem(
                color = categoryColors,
                isSelected = selectedColor == categoryColors,
                onSelect = onSelect,
            )
        }
    }
}

@Composable
private fun ColorItem(
    color: CategoryColors,
    isSelected: Boolean,
    onSelect: (CategoryColors) -> Unit,
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .padding(4.dp)
            .clickable { onSelect(color) }
            .background(
                color = Color(color.hexValue.toColorInt()),
                shape = CircleShape,
            )
            .border(
                BorderStroke(
                    width = 2.dp,
                    color = if (isSelected) Color.Black else Color(color.hexValue.toColorInt()),
                ),
                shape = CircleShape,
            ),
    )
}

@Composable
private fun EmojiPickerDialog(
    onEmojiChange: (String) -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        AndroidView(
            modifier = Modifier
                .padding(vertical = 32.dp)
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(16.dp),
                )
                .padding(8.dp),
            factory = {
                EmojiPickerView(it).apply {
                    setOnEmojiPickedListener { item ->
                        onEmojiChange(item.emoji)
                        onDismiss()
                    }
                }
            },
        )
    }
}

@Composable
private fun EmojiPicker(
    emoji: String,
    backGroundColor: CategoryColors,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .padding(4.dp)
            .clickable(onClick = onClick)
            .background(
                color = Color(backGroundColor.hexValue.toColorInt()),
                shape = CircleShape,
            )
            .border(
                BorderStroke(
                    width = Dp.Hairline,
                    color = Color.Black,
                ),
                shape = CircleShape,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = emoji)
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

@Preview
@Composable
private fun ColorItemPreview() {
    ColorItem(
        color = CategoryColors.BLUE,
        isSelected = false,
        onSelect = {},
    )
}