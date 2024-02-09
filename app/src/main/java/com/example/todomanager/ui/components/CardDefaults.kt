package com.example.todomanager.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

object CardDefaults {
    private val CardHorizontalPadding = 16.dp
    private val CardVerticalPadding = 24.dp

    val contentPadding = PaddingValues(
        start = CardHorizontalPadding,
        top = CardVerticalPadding,
        end = CardHorizontalPadding,
        bottom = CardVerticalPadding,
    )
}