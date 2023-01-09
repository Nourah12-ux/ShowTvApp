package com.example.nourahalhindi_belt_exam2.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShowTable::class], version = 1, exportSchema = false)
abstract class ShowDatabase :RoomDatabase(){
    abstract fun showDao():ShowDao

    companion object{
        @Volatile
        private var Instance:ShowDatabase?=null

        fun getDatabase(context: Context):ShowDatabase{
            val ItemInctance= Instance
            if (ItemInctance!=null) {
                return ItemInctance
            }
            synchronized(this){  // protection from concurrent execution on multiple threads
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShowDatabase::class.java,
                    "show_table"
                ).fallbackToDestructiveMigration()  // Destroys old database on version change
                    .build()
                Instance = instance
                return instance
            }
        }
    }
}