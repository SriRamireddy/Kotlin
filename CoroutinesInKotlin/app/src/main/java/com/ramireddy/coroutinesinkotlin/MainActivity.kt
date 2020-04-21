package com.ramireddy.coroutinesinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import kotlin.reflect.KFunction1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main

            CoroutinesScope(Dispatchers.IO).launch{
            fectCatFact()
        }
    }



    suspend fun fectCatFact(){

        val url = URL("")
        val http : HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inp : InputStream = http.inputStream
        val text = inp.bufferedReader().use { BufferedReader::readText }

        withContext(Dispatchers.Main){
            setValue(text)

        }
    }

    private fun setValue(text : String) {


    }
}
