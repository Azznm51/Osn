package com.example.data.local

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "user_scores")
data class UserScore(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category: String,
    val score: Int,
    val correctCount: Int,
    val totalCount: Int,
    val timestamp: Long = System.currentTimeMillis()
)

@Dao
interface UserScoreDao {
    @Query("SELECT * FROM user_scores ORDER BY timestamp DESC")
    fun getAllScores(): Flow<List<UserScore>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScore(score: UserScore)

    @Query("DELETE FROM user_scores")
    suspend fun clearAllScores()
}

@Database(entities = [UserScore::class], version = 1, exportSchema = false)
abstract class QuizDatabase : RoomDatabase() {
    abstract fun userScoreDao(): UserScoreDao

    companion object {
        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getDatabase(context: Context): QuizDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "geosn_quiz_db"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
