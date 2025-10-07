package com.example.my_boat.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// UserDatabase represents database and contains the database holder and server the main access point for the underlying connection to your app's persisted, relational data.

@Database(
    entities = [Boat::class],
    version = 1,                // <- Database version
    exportSchema = true
)
abstract class MyBoatDatabase: RoomDatabase() { // <- Add 'abstract' keyword and extends RoomDatabase
    abstract fun boatDao(): BoatDao

    companion object {
        @Volatile
        var INSTANCE: MyBoatDatabase? = null

        fun getDatabase(context: Context): MyBoatDatabase{
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyBoatDatabase::class.java,
                    "my_boat_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}