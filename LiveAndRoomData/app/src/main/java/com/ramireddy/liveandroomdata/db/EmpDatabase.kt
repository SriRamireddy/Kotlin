package com.ramireddy.liveandroomdata.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [EmpClass::class],version = 1)
abstract class EmpDatabase: RoomDatabase() {

    abstract val dao : MyDao
    companion object{
        private var instant : EmpDatabase?=null
        fun getInstance(context : Context):EmpDatabase{
            synchronized(this){
                var instance = instant

                if (instance==null){
                    instance=Room.databaseBuilder(context.applicationContext,
                    EmpDatabase::class.java,"emp_data").build()
                }
                return instance
            }
        }
    }
}