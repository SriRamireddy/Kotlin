package com.rrr.logintask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rrr.logintask.apicalls.ApiCall;
import com.rrr.logintask.apicalls.RetrofitRequest;
import com.rrr.logintask.databinding.ActivityMainBinding;
import com.rrr.logintask.model.Datum;
import com.rrr.logintask.model.LoginApi;
import com.rrr.logintask.room.UserViewmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private UserViewmodel userViewModel;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        final RetrofitRequest apiData = ApiCall.getInstance();

        userViewModel = new ViewModelProvider(this).get(UserViewmodel.class);
        userViewModel.getmAllWords().observe(this, data -> {
            if(data.size()>0){
                Log.d(TAG, "onChanged: databased");
            }else{
                Call<LoginApi> callData = apiData.getData("<n");
                callData.enqueue(new Callback<LoginApi>() {
                    @Override
                    public void onResponse(Call<LoginApi> call, Response<LoginApi> response) {

                        Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
                        List<Datum> list=response.body().getData();
                        for(int i=0;i<=list.size()-1;i++){
                            userViewModel.insert(list.get(i));
                            Toast.makeText(MainActivity.this, "inserted", Toast.LENGTH_SHORT).show();
                        }
                        if (response.body().getTotalPages()>1){
                            for (int i=2;i<=response.body().getTotalPages();i++){
                                loadData(i);
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<LoginApi> call, Throwable t) {
                        Log.d("responseFailed", ""+t.getMessage());
                    }
                });
            }
        });
    }


    private void loadData(int i) {

        RetrofitRequest apiData = ApiCall.getInstance();
        Call<LoginApi> callData = apiData.getData(""+i);
        callData.enqueue(new Callback<LoginApi>() {
            @Override
            public void onResponse(Call<LoginApi> call, Response<LoginApi> response) {
                //Save data to Room database here!!!
                //Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
                List<Datum> list=response.body().getData();
                for(int i=0;i<=list.size()-1;i++){
                    UserViewmodel.insert(list.get(i));
                }

            }

            @Override
            public void onFailure(Call<LoginApi> call, Throwable t) {

            }
        });
    }

}
