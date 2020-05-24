package com.ramireddy.liveandroomdata.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface MyDao
{
    @Insert
    fun insertEmp(emp : EmpClass)
    @Update
    fun updateEmp(emp : EmpClass)
    @Delete
    fun deleteEmp(emp : EmpClass)
    @Query("DELETE FROM Emp")
    fun deleteAll()
    @Query("SELECT * FROM Emp")
    fun getData():LiveData<List<EmpClass>>
}