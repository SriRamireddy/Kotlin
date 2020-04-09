package com.ramireddy.intentskotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.ramireddy.intentskotlin.databinding.ActivityMainBinding
import com.ramireddy.intentskotlin.databinding.ActivitySecondBinding
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    lateinit var databinding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_second)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_second)
        val m = intent.getStringExtra("Key")
        databinding.datadisplay.text = m
    }

    fun reply(view: View) {

        //val e = findViewById<EditText>(R.id.rply)
        //val r = e.text.toString;
        val i = Intent()
        i.putExtra("key1","data1")
        setResult(Activity.RESULT_OK,i)
        finish()
    }
}
