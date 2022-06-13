package com.example.nutricare

import androidx.room.*

@Dao
interface InfoDao {

    //Aqui hago el CRUD
    @Query("select * from info")
    fun getAll(): List<Info>

    @Insert
    fun insertInfo(vararg contact: Info)

    @Delete
    fun deleteInfo(vararg contact: Info)

    @Update
    fun updateInfo(vararg contact: Info)
}