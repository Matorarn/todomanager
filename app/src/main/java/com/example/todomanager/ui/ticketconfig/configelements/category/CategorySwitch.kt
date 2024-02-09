package com.example.todomanager.ui.ticketconfig.configelements.category

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todomanager.data.category.Category
import com.example.todomanager.data.category.CategoryColors
import com.example.todomanager.data.category.mockCategories

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
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(8.dp),
    ) {
        Text(
            text = "Kategorie",
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        // TODO Check if overflow, when scrolling, is correctly displayed
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState()),
        ) {
            categoryList.forEachIndexed { index, category ->
                if (category != null) {
                    CategoryItem(
                        category = category,
                        isSelected = selectedCategory == categoryList[index],
                        // TODO Is Index really needed? Is it possible to just use the lambda?
                        onClick = { categoryList[index]?.let { onSelectCategory(it) } },
                    )
                }
            }
            if (categoryList.isNotEmpty()) {
                Spacer(Modifier.width(16.dp))
            }
            // TODO Replace AddButton
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
private fun CategorySwitchSelectedPreview() {
    CategorySwitch(
        categoryList = mockCategories,
        selectedCategory = mockCategories[0],
        onSelectCategory = {},
        showAddCategoryDialog = {},
    )
}

@Preview
@Composable
private fun CategorySwitchEmptyPreview() {
    CategorySwitch(
        categoryList = emptyList(),
        selectedCategory = null,
        onSelectCategory = {},
        showAddCategoryDialog = {},
    )
}