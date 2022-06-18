package com.example.nutricare

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Payment (

    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo (name = "name_card")
    var name_card: String?,

    @ColumnInfo (name = "name")
    var name: String?,

    @ColumnInfo (name = "card_number")
    var card_number: String?,

    @ColumnInfo (name = "expiration_date")
    var expiration_date: String?,

    @ColumnInfo (name = "ccv")
    var ccv: String?,
)