package com.example.nutricare

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PaymentDao {

    @Query("select * from payment")
    fun getAll(): List<Payment>

    @Insert
    fun insertPaymentMethod(vararg contact: Payment)


}