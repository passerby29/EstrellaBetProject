package esterella.cheeseit.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_international")
data class InternationalEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val mId: Int,
    @ColumnInfo(name = "question") val mQuestion: String?,
    @ColumnInfo(name = "answer") val mAnswer: String?,
    @ColumnInfo(name = "result") val mResult: Int?,
)
