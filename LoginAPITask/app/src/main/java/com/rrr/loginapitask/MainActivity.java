package com.rrr.loginapitask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rrr.loginapitask.model.LoginApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitRequest apiData = retrofit.create(RetrofitRequest.class);
        Call<LoginApi> callData = apiData.getData("<n");
        callData.enqueue(new Callback<LoginApi>() {
            @Override
            public void onResponse(Call<LoginApi> call, Response<LoginApi> response) {

                Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
               LoginApi loginApi=response.body();

               if (response.body().getTotalPages()>1){
                   for (int i=2;i<=response.body().getTotalPages();i++){
                       loadData(i);
                   }
               }

               /* WikiModel wikiModel=response.body();
                //Toast.makeText(MainActivity.this, ""+wikiModel.getQuery().getPages().size(), Toast.LENGTH_SHORT).show();
                for(int i=0;i<wikiModel.getQuery().getPages().size();i++){
                    mWordViewModel.insert(wikiModel.getQuery().getPages().get(i));
                }*/

            }
            @Override
            public void onFailure(Call<LoginApi> call, Throwable t) {
                Log.d("responseFailed", ""+t.getMessage());
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.page1,new DataFragment());
        transaction.commit();
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.page2,new ProfileFragment());
        transaction1.commit();


    }

    private void loadData(int i) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitRequest apiData = retrofit.create(RetrofitRequest.class);
        Call<LoginApi> callData = apiData.getData(""+i);
        callData.enqueue(new Callback<LoginApi>() {
            @Override
            public void onResponse(Call<LoginApi> call, Response<LoginApi> response) {
                //Save data to Room database here!!!
                Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
            }
            @Override
            public void onFailure(Call<LoginApi> call, Throwable t) {

            }
        });
    }

}
