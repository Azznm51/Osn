package com.example.data.repository

import com.example.data.local.UserScore
import com.example.data.local.UserScoreDao
import kotlinx.coroutines.flow.Flow

class QuizRepository(private val scoreDao: UserScoreDao) {
    val allScores: Flow<List<UserScore>> = scoreDao.getAllScores()

    suspend fun insertScore(userScore: UserScore) {
        scoreDao.insertScore(userScore)
    }

    suspend fun clearHistory() {
        scoreDao.clearAllScores()
    }
}
