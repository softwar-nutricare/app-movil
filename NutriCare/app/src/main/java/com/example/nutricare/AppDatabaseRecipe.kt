package com.example.nutricare

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Recipe::class), version = 1)
abstract class AppDatabaseRecipe: RoomDatabase() {
    abstract fun getDao(): RecipeDao

    //utiliza un patron singleton
    companion object{
        private var INSTANCE: AppDatabaseRecipe? = null

        fun getInstance(context: Context): AppDatabaseRecipe{
            if (INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabaseRecipe::class.java, "recipe.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabaseRecipe
        }
    }

}