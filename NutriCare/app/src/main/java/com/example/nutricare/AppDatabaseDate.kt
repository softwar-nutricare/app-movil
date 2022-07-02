package com.example.nutricare

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Date::class), version = 1)
abstract class AppDatabaseDate: RoomDatabase() {

    abstract fun getDao(): DateDao

    //utiliza un patron singleton
    companion object{
        private var INSTANCE: AppDatabaseDate? = null

        fun getInstance(context: Context): AppDatabaseDate{
            if (INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabaseDate::class.java, "date.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabaseDate
        }
    }
}