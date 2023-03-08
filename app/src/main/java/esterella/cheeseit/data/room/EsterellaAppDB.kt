package esterella.cheeseit.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        InternationalEntity::class,
        EPLEntity::class,
        EuropeEntity::class,
        WorldEntity::class,
    ], exportSchema = false, version = 2
)
abstract class EsterellaAppDB : RoomDatabase() {

    abstract fun getInternationalDao(): InternationalDao
    abstract fun getEPLDao(): EPLDao
    abstract fun getEuropeDao(): EuropeDao
    abstract fun getWorldDao(): WorldDao

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