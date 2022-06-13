package com.example.nutricare

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Info::class), version = 1)
abstract class AppDatabaseInfo: RoomDatabase() {

    abstract fun getDao(): InfoDao

    //utiliza un patron singleton
    companion object{
        private var INSTANCE: AppDatabaseInfo? = null

        fun getInstance(context: Context): AppDatabaseInfo{
            if (INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabaseInfo::class.java, "info.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabaseInfo
        }
    }
}