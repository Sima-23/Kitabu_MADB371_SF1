package com.example.kitabu.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        BookEntity::class,
        BookingEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class KitabuDatabase : RoomDatabase() {

    abstract fun libraryDao(): LibraryDao

    companion object {

        @Volatile
        private var INSTANCE: KitabuDatabase? = null

        fun getDatabase(context: Context): KitabuDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    KitabuDatabase::class.java,
                    "kitabu_database"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}