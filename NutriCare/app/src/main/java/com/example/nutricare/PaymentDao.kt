package com.example.nutricare

import androidx.room.*

@Dao
interface PaymentDao {

    @Query("select * from payment")
    fun getAll(): List<Payment>

    @Insert
    fun insertPaymentMethod(vararg contact: Payment)

    @Delete
    fun deletePaymentMethod(vararg contact: Payment)

    @Update
    fun updatePaymentMethod(vararg contact: Payment)

}