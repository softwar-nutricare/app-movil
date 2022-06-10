package com.example.nutricare

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //anotaciones de ROOM
//necesariamente tiene q ser data class
data class Recipe (
    //ROOM necesariamente debe gener un PK
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "description")
    var description:String?,

    @ColumnInfo(name = "N_Calories")
    var N_Calories:String?,

    @ColumnInfo(name = "N_Ingredients")
    var N_Ingredients:String?,

    @ColumnInfo(name = "T_Preparation")
    var T_Preparation:String?
)