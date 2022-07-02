package com.example.nutricare

import androidx.room.*

@Dao
interface DateDao {

    //Aqui hago el CRUD
    @Query("select * from date")
    fun getAll(): List<Date>

    @Insert
    fun insertDate(vararg contact: Date)

    @Delete
    fun deleteDate(vararg contact: Date)

    @Update
    fun updateDate(vararg contact: Date)
}