package com.example.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.QuizDatabase
import com.example.data.local.UserScore
import com.example.data.model.Question
import com.example.data.model.QuestionProvider
import com.example.data.model.StudyTopic
import com.example.data.repository.QuizRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class Screen {
    Dashboard,
    MateriList,
    MateriDetail,
    QuizPrep, // Select category, number of questions
    QuizActive,
    QuizSummary,
    Stats
}

data class Badge(
    val name: String,
    val description: String,
    val iconName: String,
    val isEarned: Boolean
)

class QuizViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: QuizRepository
    val allScores: StateFlow<List<UserScore>>

    init {
        val database = QuizDatabase.getDatabase(application)
        repository = QuizRepository(database.userScoreDao())
        allScores = repository.allScores.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    }

    // Active Navigation
    var currentScreen by mutableStateOf(Screen.Dashboard)
        private set

    fun navigateTo(screen: Screen) {
        currentScreen = screen
    }

    // Selected Topic for Study Mode
    var selectedTopic by mutableStateOf<StudyTopic?>(null)
        private set

    fun selectTopic(topic: StudyTopic) {
        selectedTopic = topic
        navigateTo(Screen.MateriDetail)
    }

    // Quiz Configuration
    var selectedQuizCategory by mutableStateOf("Semua Kategori")
    var selectedQuestionCount by mutableStateOf(10) // 5, 10, or 20

    // Active Quiz Session State
    var activeQuestions by mutableStateOf<List<Question>>(emptyList())
        private set
    var currentQuestionIndex by mutableStateOf(0)
        private set
    var selectedAnswerIndex by mutableStateOf<Int?>(null)
    var isAnswerSubmitted by mutableStateOf(false)
    var correctAnswersCount by mutableStateOf(0)
    var quizSecondsElapsed by mutableStateOf(0)
    
    private var timerJob: Job? = null

    fun startQuiz() {
        val filtered = if (selectedQuizCategory == "Semua Kategori") {
            QuestionProvider.questions
        } else {
            QuestionProvider.questions.filter { it.category == selectedQuizCategory }
        }
        
        // Shuffle and limit
        activeQuestions = filtered.shuffled().take(selectedQuestionCount)
        currentQuestionIndex = 0
        selectedAnswerIndex = null
        isAnswerSubmitted = false
        correctAnswersCount = 0
        quizSecondsElapsed = 0

        startTimer()
        navigateTo(Screen.QuizActive)
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000)
                quizSecondsElapsed++
            }
        }
    }

    private fun stopTimer() {
        timerJob?.cancel()
    }

    fun selectOption(index: Int) {
        if (!isAnswerSubmitted) {
            selectedAnswerIndex = index
        }
    }

    fun submitAnswer() {
        if (selectedAnswerIndex == null || isAnswerSubmitted) return
        isAnswerSubmitted = true
        
        val currentQuestion = activeQuestions[currentQuestionIndex]
        if (selectedAnswerIndex == currentQuestion.correctAnswerIndex) {
            correctAnswersCount++
        }
    }

    fun nextQuestion() {
        if (currentQuestionIndex < activeQuestions.size - 1) {
            currentQuestionIndex++
            selectedAnswerIndex = null
            isAnswerSubmitted = false
        } else {
            finishQuiz()
        }
    }

    private fun finishQuiz() {
        stopTimer()
        val scorePercent = ((correctAnswersCount.toFloat() / activeQuestions.size) * 100).toInt()
        
        viewModelScope.launch {
            repository.insertScore(
                UserScore(
                    category = selectedQuizCategory,
                    score = scorePercent,
                    correctCount = correctAnswersCount,
                    totalCount = activeQuestions.size
                )
            )
        }
        navigateTo(Screen.QuizSummary)
    }

    fun restartQuizFromSummary() {
        startQuiz()
    }

    fun clearHistory() {
        viewModelScope.launch {
            repository.clearHistory()
        }
    }

    // Derived Statistics and Progress Indicators
    fun getReadinessProgress(scores: List<UserScore>): Float {
        if (scores.isEmpty()) return 0.1f // first launch padding
        val avgScore = scores.map { it.score }.average().toFloat()
        // scaling readiness with caps
        return (avgScore / 100f).coerceIn(0.1f, 1.0f)
    }

    fun getAverageScore(scores: List<UserScore>): Int {
        if (scores.isEmpty()) return 0
        return scores.map { it.score }.average().toInt()
    }

    fun getAccuracyPercent(scores: List<UserScore>): Int {
        val totalCorrect = scores.sumOf { it.correctCount }
        val totalCount = scores.sumOf { it.totalCount }
        if (totalCount == 0) return 0
        return ((totalCorrect.toFloat() / totalCount) * 100).toInt()
    }

    fun getDiagnosticStrengths(scores: List<UserScore>): List<Pair<String, Int>> {
        val categories = listOf(
            "Cuaca dan Iklim", "Oseanografi", "Kebencanaan dan Manajemen Bencana",
            "Sumberdaya dan Manajemen Sumberdaya", "Geografi Lingkungan dan Pembangun",
            "Perubahan Roman Muka Bumi", "Pertanian dan Permasalahan Pangan",
            "Kependudukan dan Dinamika Penduduk", "Geografi Ekonomi",
            "Pariwisata dan Manajemen Pariwisata"
        )
        return categories.map { category ->
            val catScores = scores.filter { it.category == category || (category == "Geografi Lingkungan" && it.category.startsWith("Geografi Lingkungan")) }
            if (catScores.isEmpty()) {
                category to 0 // No stats yet
            } else {
                category to catScores.map { it.score }.average().toInt()
            }
        }
    }

    fun getEarnedBadges(scores: List<UserScore>): List<Badge> {
        val list = mutableListOf<Badge>()

        // Badge 1: Perintis GeoSN
        list.add(
            Badge(
                name = "Perintis GeoSN",
                description = "Menyelesaikan kuis pertama kali",
                iconName = "Star",
                isEarned = scores.isNotEmpty()
            )
        )

        // Badge 2: Ahli Meteorologi
        val weatherPerfect = scores.any { it.category == "Cuaca dan Iklim" && it.score == 100 }
        list.add(
            Badge(
                name = "Ahli Meteorologi",
                description = "Skor 100% pada kategori cuaca",
                iconName = "WbSunny",
                isEarned = weatherPerfect
            )
        )

        // Badge 3: Master Oseanografi
        val oceanScores = scores.filter { it.category == "Oseanografi" }
        list.add(
            Badge(
                name = "Arsitek Samudra",
                description = "Menyelesaikan 3 kuis Oseanografi",
                iconName = "Water",
                isEarned = oceanScores.size >= 3
            )
        )

        // Badge 4: Pejuang Tangguh
        val hasPerfectTen = scores.any { it.totalCount >= 10 && it.score == 100 }
        list.add(
            Badge(
                name = "Medalis Emas",
                description = "Skor sempurna (100%) dengan minimal 10 soal",
                iconName = "EmojiEvents",
                isEarned = hasPerfectTen
            )
        )

        // Badge 5: Tekad membaja
        list.add(
            Badge(
                name = "Penjelajah Tekun",
                description = "Menyelesaikan total 5 sesi kuis latihan",
                iconName = "HistoryEdu",
                isEarned = scores.size >= 5
            )
        )

        return list
    }
}
