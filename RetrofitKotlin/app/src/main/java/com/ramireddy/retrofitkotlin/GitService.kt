package com.ramireddy.retrofitkotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService
{
    @GET("users/{user}/repos")
    fun listrepo(@Path("user") user : String): Call<String>

}