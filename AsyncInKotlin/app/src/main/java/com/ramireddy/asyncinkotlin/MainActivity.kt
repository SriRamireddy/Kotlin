package com.ramireddy.asyncinkotlin

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    class FetchCatFact(val context : Context ,result : String) : AsyncTask<String, Void, Void>()
    {
        override fun doInBackground(vararg p0: String?): Void {

            return null!!
        }

    }

}
