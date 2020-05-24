package com.rrr.logintask.apicalls;

import com.rrr.logintask.model.LoginApi;
import com.rrr.logintask.model.TokenResponse;
import com.rrr.logintask.model.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitRequest
{
    @GET("users")
    Call<LoginApi> getData(@Query("page") String id);

    @POST("login")
    Call<TokenResponse> login(@Body UserLogin login);

}
