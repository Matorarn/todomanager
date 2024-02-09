package com.example.todomanager.ui.ticketconfig.configelements.dialogs.addcategory

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.todomanager.data.category.CategoryColors

@Composable
fun ColorPicker(
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

@Preview
@Composable
private fun ColorPickerPreview() {
    ColorPicker(
        selectedColor = CategoryColors.RED,
        onSelect = {},
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