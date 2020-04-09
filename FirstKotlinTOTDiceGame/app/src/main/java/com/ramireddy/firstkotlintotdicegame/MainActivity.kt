package com.ramireddy.firstkotlintotdicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showToast(view: View) {
        //random number
        val r = (1..6).random()
        val tv : TextView = findViewById(R.id.result)
        val im : ImageView = findViewById(R.id.image)
        //tv.setText(r.toString()) //or
        tv.text = r.toString()
        when (r) {
            1 -> im.setImageResource(R.drawable.dice_1)
            2 -> im.setImageResource(R.drawable.dice_2)
            3 -> im.setImageResource(R.drawable.dice_3)
            4 -> im.setImageResource(R.drawable.dice_4)
            5 -> im.setImageResource(R.drawable.dice_5)
            6 -> im.setImageResource(R.drawable.dice_6)
        }
       /*val toast : Toast = Toast.makeText(this,"random number "+r,Toast.LENGTH_LONG);
        toast.show();*/
    }
}
