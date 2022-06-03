package com.cypher.forfuckssake.Wordle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class WordleViewModel : ViewModel(){
    var state by mutableStateOf(WordleState())
        private set


    var placeholder : String = ""

    fun setWord(word : String) {
       state = state.copy(
           finalWord = word + (state.firstLetter?.letter ?: "")

       )
    }

    fun setFirstLetter(letter : String) {
        state.firstLetter?.letter = letter
    }
    fun setSecondLetter(letter : String) {
        state.secondLetter?.letter = letter
    }
    fun setThirdLetter(letter : String) {
        state.thirdLetter?.letter = letter
    }
    fun setFourthLetter(letter : String) {
        state.fourthLetter?.letter = letter
    }
    fun setFifthLetter(letter : String) {
        state.fifthLetter?.letter = letter
    }
}