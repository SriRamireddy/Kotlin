package com.ramireddy.viewmodelalivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var tv : TextView
    lateinit var myview : MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tt)
        myview = ViewModelProvider(this).get(MyViewModel::class.java)

        val r = (1..100).random()
        tv.text = myview.r.toString()
    }
}
