package com.cypher.forfuckssake.Wordle

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

data class WordleBox (
    var letter : String? = "",
    val color : Color = Color.White
)