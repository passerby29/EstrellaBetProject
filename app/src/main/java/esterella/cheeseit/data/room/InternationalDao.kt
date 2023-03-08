package esterella.cheeseit.data.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface InternationalDao {

    @Query("select * from test_international where question = 'Какой счет был в финале Евро-2012?'")
    suspend fun getQuestion1(): List<InternationalEntity>
}