package com.example.nutricare

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Info::class), version = 1)
abstract class AppDatabasePayment: RoomDatabase() {

    abstract fun getDao(): PaymentDao

    companion object{
        private var INSTANCE: AppDatabasePayment? = null

        fun getInstance(context: Context): AppDatabasePayment{
            if(INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabasePayment::class.java, "payment.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabasePayment
        }
    }
}