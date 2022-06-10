package com.example.nutricare

import androidx.room.*

@Dao
interface RecipeDao {

    //Aqui hago el CRUD
    @Query("select * from recipe")
    fun getAll(): List<Recipe>

    @Insert
    fun insertRecipe(vararg contact: Recipe)

    @Delete
    fun deleteRecipe(vararg contact: Recipe)

    @Update
    fun updateRecipe(vararg contact: Recipe)
}