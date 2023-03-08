package esterella.cheeseit.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [InternationalEntity::class], exportSchema = false, version = 1)
abstract class EsterellaAppDB : RoomDatabase() {

    abstract fun getInternationalDao(): InternationalDao

    companion object {
        fun getDB(context: Context): EsterellaAppDB {
            return Room.databaseBuilder(
                context,
                EsterellaAppDB::class.java,
                "esterella-database"
            ).createFromAsset("databases/estrella.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}