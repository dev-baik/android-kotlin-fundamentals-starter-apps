package com.example.guesstheword_starter.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {

    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
    }

    // The final score
    var score = finalScore
}