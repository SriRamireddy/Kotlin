package com.ramireddy.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ramireddy.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var databinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
       // val text = databinding.samplebind.text
        /*val toast : Toast = Toast.makeText(this,"hello binding",Toast.LENGTH_LONG)
        toast.show()*/

        databinding.button.setOnClickListener { setName() }

    }
    private fun setName(){


        val n = databinding.name.text.toString()
        val d = Myname(n)
       // databinding.namedisplay.text = n
        databinding.name.text.clear()
    }
}
