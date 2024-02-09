package com.example.todomanager.data.category

data class Category(
    val id: Int = 0,
    val title: String,
    val emoji: String,
    val color: CategoryColors,
)