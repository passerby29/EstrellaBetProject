package esterella.cheeseit.data.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface EPLDao {

    @Query("select * from test_epl where question_id = :questionId")
    suspend fun getEPLTest(questionId: Int): List<EPLEntity>
}