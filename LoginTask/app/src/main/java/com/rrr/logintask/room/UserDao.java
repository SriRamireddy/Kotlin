package com.rrr.logintask.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.rrr.logintask.model.Datum;

import java.util.List;

@Dao
public interface UserDao
{
    @Insert
    void insert(Datum datum);

    @Query("SELECT * from Datum")
    LiveData<List<Datum>> getUserdata();

}
