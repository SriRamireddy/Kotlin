package com.ramireddy.liveandroomdata.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Emp")
data class EmpClass(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "emp_id")
    val id:Int,
    var name:String,
var email:String)

