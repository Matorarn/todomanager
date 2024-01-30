package com.example.todomanager.data.category

import androidx.compose.ui.graphics.Color

val mockCategory = Category(
    title = "Privat",
    emoji = "\uD83D\uDECD\uFE0F",
    color = Color.Cyan.value.toInt(),
)

val mockCategories = listOf<Category>(
    Category(
        title = "Privat",
        emoji = "\uD83D\uDECD\uFE0F",
        color = Color.Cyan.value.toInt(),
    ),
    Category(
        title = "Urlaub",
        emoji = "\uD83D\uDECD\uFE0F",
        color = Color.LightGray.value.toInt(),
    ),
    Category(
        title = "Arbeit",
        emoji = "\uD83D\uDECD\uFE0F",
        color = Color.Gray.value.toInt(),
    ),
    Category(
        title = "Wohnung",
        emoji = "\uD83D\uDECD\uFE0F",
        color = Color.Blue.value.toInt(),
    ),
    Category(
        title = "Freunde",
        emoji = "\uD83D\uDECD\uFE0F",
        color = Color.Magenta.value.toInt(),
    ),
)