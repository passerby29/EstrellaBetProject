package esterella.cheeseit.data.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface InternationalDao {

    @Query("select * from test_international where question_id = :questionId")
    suspend fun getInternationalTest(questionId: Int): List<InternationalEntity>
}