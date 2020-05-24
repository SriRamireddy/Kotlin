package com.ramireddy.databindingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ramireddy.databindingpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var data : ActivityMainBinding
    var c = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        data = DataBindingUtil.setContentView(this,R.layout.activity_main)

        data.incre.setOnClickListener {
            c++
            data.textDisplay.text = ""+c
        }
        data.decrement.setOnClickListener {
            c--
            if (c>=0) {
                data.textDisplay.text = "" + c
            }else{
                Toast.makeText(this,"no negative values",Toast.LENGTH_LONG).show()
            }
        }

    }
}
