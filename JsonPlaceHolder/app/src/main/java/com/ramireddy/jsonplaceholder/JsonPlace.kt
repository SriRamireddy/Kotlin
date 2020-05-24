package com.ramireddy.jsonplaceholder

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface JsonPlace
{

    @GET("posts")
    fun getallData(): Call<List<Post>>

    @POST("posts")
    fun postValue(@Body post : Post):Call<Post>


}