package com.cypher.forfuckssake.Wordle

import androidx.compose.ui.graphics.Color

data class WordleState (
    val firstLetter : WordleBox? = null,
    val secondLetter : WordleBox? = null,
    val thirdLetter : WordleBox? = null,
    val fourthLetter : WordleBox? = null,
    val fifthLetter : WordleBox? = null,
    var finalWord : String? = "Apple",
    val tries : Int = 0
)