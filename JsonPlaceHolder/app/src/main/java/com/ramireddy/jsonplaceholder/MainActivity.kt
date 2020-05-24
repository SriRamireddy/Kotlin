package com.ramireddy.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), Callback<List<Post>> {
    override fun onFailure(call: Call<List<Post>>, t: Throwable) {

        Log.i("Mainactivity",""+t.message)
    }

    override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

        Toast.makeText(this,"mainactivity",Toast.LENGTH_LONG).show()
        tv.text = ""
        val l=response.body()
        for (i in l!!){
            tv.append(i.title+"\n"+i.body+"\n")

        }

    }

    lateinit var tv : TextView
    lateinit var getbtn : Button
    lateinit var postbtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.response)
        getbtn = findViewById(R.id.get)
        postbtn = findViewById(R.id.post)

        val okttp = OkHttpClient.Builder()
            .connectTimeout(1,TimeUnit.MINUTES)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()


        /*
        *By default, the retrofit library will only wait for 10
         */

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okttp)
            .build()

        val jsonplace : JsonPlace = retrofit.create(JsonPlace::class.java)
        getbtn.setOnClickListener {
            //retrofit
            //jsonplace.getallData().enqueue(this)
        }
        postbtn.setOnClickListener {
            //jsonplace.postValue()

            val post = Post(body = " My Body ",title = "My Title ",userId = 573)
            val call = jsonplace.postValue(post)
            call.enqueue(object  : Callback<Post>{
                override fun onFailure(call: Call<Post>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"post fail",Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Post>, response: Response<Post>) {

                    Toast.makeText(this@MainActivity,"post success",Toast.LENGTH_LONG).show()

                    tv.text = ""
                    val po = response.body()
                    tv.append(""+po?.id+"\n"+po?.title+"\n"+po?.userId+"\n"+po?.body)
                }

            })
        }

    }
}
