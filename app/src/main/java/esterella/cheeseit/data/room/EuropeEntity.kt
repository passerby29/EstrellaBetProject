package esterella.cheeseit.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_europe")
data class EuropeEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val mId: Int,
    @ColumnInfo(name = "question") val mQuestion: String?,
    @ColumnInfo(name = "question_id") val mQuestionId: Int?,
    @ColumnInfo(name = "answer") val mAnswer: String?,
    @ColumnInfo(name = "result") val mResult: Int?,
)
