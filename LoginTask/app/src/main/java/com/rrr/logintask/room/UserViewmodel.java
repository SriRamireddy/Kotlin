package com.rrr.logintask.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rrr.logintask.model.Datum;

import java.util.List;

public class UserViewmodel extends AndroidViewModel {
    private  LiveData<List<Datum>> mAllWords;
    private static UserRepository mRepository;

    public UserViewmodel(@NonNull Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllWords = mRepository.getmAllUsers();
    }

    public  LiveData<List<Datum>> getmAllWords() {
        return mAllWords;
    }
    public static void insert(Datum datum) { mRepository.insert(datum); }
}
