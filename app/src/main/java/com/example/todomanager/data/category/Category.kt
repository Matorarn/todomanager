package com.example.todomanager.data.category

import androidx.annotation.ColorInt

data class Category(
    val id: Int = 0,
    val title: String,
    val emoji: String,
    @ColorInt val color: Int,
)