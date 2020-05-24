package com.rrr.logintask.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.rrr.logintask.model.Datum;

import java.util.List;

public class UserRepository
{
    private Application application;
    private UserDao mWordDao;
    private LiveData<List<Datum>> mAllUsers;
    public UserRepository(Application application) {
        this.application=application;
        UserDatabase db = UserDatabase.getDatabase(application);
        mWordDao = db.userDao();
        mAllUsers = mWordDao.getUserdata();
    }

    public void insert(final Datum datum){
        UserDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(datum);
        });
    }

    public LiveData<List<Datum>> getmAllUsers() {
        return mAllUsers;
    }
}
