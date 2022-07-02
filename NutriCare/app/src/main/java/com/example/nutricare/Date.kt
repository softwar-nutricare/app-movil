package com.example.nutricare

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //anotaciones de ROOM
data class Date(

    //ROOM necesariamente debe gener un PK
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "nutritionist")
    var nutritionist: String?,

    @ColumnInfo(name = "day")
    var day:String?,

    @ColumnInfo(name = "timeStar1")
    var timeStar1:String?,

    @ColumnInfo(name = "timeEnd1")
    var timeEnd1:String?,

    @ColumnInfo(name = "timeStar2")
    var timeStar2:String?,

    @ColumnInfo(name = "timeEnd2")
    var timeEnd2:String?,

    @ColumnInfo(name = "timeStar3")
    var timeStar3:String?,

    @ColumnInfo(name = "timeEnd3")
    var timeEnd3:String?,

    @ColumnInfo(name = "status")
    var status:String?,

    @ColumnInfo(name = "speciality")
    var speciality:String?,
)