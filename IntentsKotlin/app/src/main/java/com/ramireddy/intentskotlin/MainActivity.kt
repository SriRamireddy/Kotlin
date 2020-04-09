package com.ramireddy.intentskotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ramireddy.intentskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var databinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        /*
        * Set Onclick Listener on the button
        * */
        databinding.nextbtn.setOnClickListener { gotonext() }
    }

    private fun gotonext() {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("Key","data")
        startActivity(intent)

        startActivityForResult(intent,200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==200){
            if (resultCode == Activity.RESULT_OK && data != null){
                val r = data.getStringExtra("key1")
                val toast : Toast = Toast.makeText(this,r,Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}
