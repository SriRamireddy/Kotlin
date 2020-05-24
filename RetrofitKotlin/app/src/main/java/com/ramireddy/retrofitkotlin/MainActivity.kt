package com.ramireddy.retrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ramireddy.retrofitkotlin.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity(), Callback<String> {
    override fun onFailure(call: Call<String>, t: Throwable) {

        Toast.makeText(this,"faild",Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<String>, response: Response<String>)
    {
        binding.repos.text = response.body()
    }


    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        val gitService : GitService = retrofit.create(GitService::class.java)
        gitService.listrepo("SriRamireddy").enqueue(this)
    }
}
