package com.example.nutricare

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //anotaciones de ROOM
//necesariamente tiene q ser data class
data class Info (

    //ROOM necesariamente debe gener un PK
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "description")
    var description: String?,
)