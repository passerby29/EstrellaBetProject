package esterella.cheeseit.data.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface WorldDao {

    @Query("select * from test_world where question_id = :questionId")
    suspend fun getWorldTest(questionId: Int): List<WorldEntity>
}