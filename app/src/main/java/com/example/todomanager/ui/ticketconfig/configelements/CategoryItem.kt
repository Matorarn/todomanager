package com.example.todomanager.ui.ticketconfig.configelements

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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
import androidx.core.graphics.toColorInt
import com.example.todomanager.data.category.Category
import com.example.todomanager.data.category.CategoryColors
import com.example.todomanager.data.category.mockCategories
import com.example.todomanager.data.category.mockCategory

@Composable
fun CategorySwitch(
    categoryList: List<Category?>,
    selectedCategory: Category?,
    onSelectCategory: (Category) -> Unit,
    showAddCategoryDialog: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(8.dp),
    ) {
        Text(
            modifier = Modifier.padding(),
            text = "Kategorie",
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState()),
        ) {
            categoryList.forEachIndexed { index, category ->
                if (category != null) {
                    CategoryItem(
                        category = category,
                        isSelected = selectedCategory == categoryList[index],
                        onClick = { categoryList[index]?.let { onSelectCategory(it) } },
                    )
                }
            }
            // TODO Fix ui
            Spacer(Modifier.width(16.dp))
            CategoryItem(
                category = Category(
                    title = "",
                    emoji = "\u2795",
                    color = CategoryColors.RED,
                ),
                isSelected = false,
                onClick = showAddCategoryDialog,
            )
        }
    }
}

@Composable
private fun CategoryItem(
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
            // TODO Implement custom colors for categories
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
private fun CategorySwitchPreview() {
    CategorySwitch(
        categoryList = mockCategories,
        selectedCategory = null,
        onSelectCategory = {},
        showAddCategoryDialog = {},
    )
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