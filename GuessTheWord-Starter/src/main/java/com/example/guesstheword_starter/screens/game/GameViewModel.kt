package com.example.guesstheword_starter.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // The current word
//    var word = ""
//    val word = MutableLiveData<String>()
    private val _word = MutableLiveData<String>()
    val word: LiveData<String> = _word

    // The current score
//    var score = 0
//    val score = MutableLiveData<Int>()
    private val _score = MutableLiveData<Int>()
//    val score: LiveData<Int>
//        get() = _score
    val score: LiveData<Int> = _score

    // Event which triggers the end of the game
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean> = _eventGameFinish

    init {
//        word.value = ""
//        score.value = 0
        _word.value = ""
        _score.value = 0
        resetList()
        nextWord()
        Log.i("GameViewModel", "GameViewModel created!")
    }

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /** Methods for buttons presses **/

    fun onSkip() {
//        score--
//        score.value = score.value?.minus(1)
        _score.value = score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
//        score++
//        score.value = score.value?.plus(1)
        _score.value = score.value?.plus(1)
        nextWord()
    }

    /** Method for the game completed event **/
    fun onGameFinish() {
        _eventGameFinish.value = true
    }

    /** Method for the game completed event **/
    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if(wordList.isEmpty()) {
            onGameFinish()
        } else {
            //Select and remove a word from the list
//            word = wordList.removeAt(0)
//            word.value = wordList.removeAt(0)
            _word.value = wordList.removeAt(0)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}