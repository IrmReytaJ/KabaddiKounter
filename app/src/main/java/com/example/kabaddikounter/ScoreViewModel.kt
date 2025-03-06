package com.example.kabaddikounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    // menyimpan skor Team A
    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> get() = _scoreA

    // menyimpan skor Team B
    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> get() = _scoreB

    // menambah skor Team A
    fun addScoreA(points: Int) {
        _scoreA.value = (_scoreA.value ?: 0) + points
    }

    // menambah skor Team B
    fun addScoreB(points: Int) {
        _scoreB.value = (_scoreB.value ?: 0) + points
    }

    // reset skor
    fun resetScores() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}