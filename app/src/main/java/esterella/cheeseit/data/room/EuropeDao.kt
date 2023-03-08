package esterella.cheeseit.data.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface EuropeDao {

    @Query("select * from test_europe where question_id = :questionId")
    suspend fun getEuropeTest(questionId: Int): List<EuropeEntity>
}