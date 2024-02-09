package com.example.todomanager.ui.ticketconfig.configelements.category

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.todomanager.data.category.Category
import com.example.todomanager.data.category.mockCategory

@Composable
fun CategoryItem(
    category: Category,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 2.dp)
            .border(
                border = BorderStroke(
                    width = Dp.Hairline,
                    color = Color.Black,
                ),
                shape = RoundedCornerShape(16.dp),
            )
            .background(
                color = Color(category.color.hexValue.toColorInt()),
                shape = if (isSelected) RoundedCornerShape(16.dp) else CircleShape,
            )
            .padding(8.dp)
            .clickable(onClick = onClick)
            .animateContentSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = category.emoji)
        if (isSelected) {
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = category.title)
        }
    }
}

@Preview
@Composable
private fun CategoryItemPreview() {
    CategoryItem(
        category = mockCategory,
        isSelected = true,
        onClick = {},
    )
}