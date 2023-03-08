package esterella.cheeseit.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [InternationalEntity::class], exportSchema = false, version = 1)
abstract class EsterellaAppDB: RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: EsterellaAppDB? = null
        fun getDB(context: Context): EsterellaAppDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EsterellaAppDB::class.java,
                    "esterella_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}