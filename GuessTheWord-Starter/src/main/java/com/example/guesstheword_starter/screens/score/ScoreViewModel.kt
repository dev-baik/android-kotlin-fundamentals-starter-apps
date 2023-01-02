package com.example.guesstheword_starter.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {

    // The final score
//    var score = finalScore
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
        _score.value = finalScore
    }
}