package com.example.todomanager.ui.ticketconfig.configelements.dialogs.addcategory

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.todomanager.data.category.CategoryColors

@Composable
fun EmojiPickerDialog(
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
fun EmojiPicker(
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
private fun EmojiPickerPreview() {
    EmojiPicker(
        emoji = "\uD83D\uDE00",
        backGroundColor = CategoryColors.RED,
        onClick = {},
    )
}

@Preview
@Composable
private fun EmojiPickerDialogPreview() {
    EmojiPickerDialog(
        onEmojiChange = {},
        onDismiss = {},
    )
}