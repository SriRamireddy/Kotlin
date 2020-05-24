package com.rrr.logintask.apicalls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCall
{
    private static Retrofit apicall;
    private static RetrofitRequest retrofitRequest;
    public static RetrofitRequest getInstance(){
        if(apicall==null){
            apicall=new Retrofit.Builder()
                    .baseUrl("https://reqres.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            retrofitRequest=apicall.create(RetrofitRequest.class);

        }
        return retrofitRequest;
    }
}
