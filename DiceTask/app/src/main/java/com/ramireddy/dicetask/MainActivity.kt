package com.ramireddy.dicetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var player1l : Button
    lateinit var player2l : Button
    lateinit var p1rcount : TextView
    lateinit var p2rcount : TextView
    lateinit var img1 : ImageView
    lateinit var img2 : ImageView

    var p1roolcount : Int = 0
    var p2roolcount : Int = 0
    var r1 : Int = 0
    var r2 : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /*  player1l = findViewById(R.id.player1_button)
        player2l = findViewById(R.id.player2_button)*/
        p1rcount = findViewById(R.id.p1roll_countdisplay)
        p2rcount = findViewById(R.id.p2roll_countdisplay)
        img1 = findViewById(R.id.player1_dice)
        img2 = findViewById(R.id.player2_dice)
      //  player2l.isEnabled = false
    }

    fun player1(view: View) {


      /*  player2l.isEnabled = true
        player1l.isEnabled = false*/
        //random number
        r1 = (1..6).random()
        p1roolcount = p1roolcount+r1
        p1rcount.text = "P1 Total count : "+ p1roolcount.toString()
        val tv : TextView = findViewById(R.id.player1_result)
        //tv.setText(r.toString()) //or
        tv.text = "Value : "+r1.toString()
        when (r1) {
            1 -> img1.setImageResource(R.drawable.dice_1)
            2 -> img1.setImageResource(R.drawable.dice_2)
            3 -> img1.setImageResource(R.drawable.dice_3)
            4 -> img1.setImageResource(R.drawable.dice_4)
            5 -> img1.setImageResource(R.drawable.dice_5)
            6 -> img1.setImageResource(R.drawable.dice_6)
        }
        player2()

    }
    fun player2() {


       /* player2l.isEnabled = false
        player1l.isEnabled = true*/
        //random number
        r2 = (1..6).random()
        p2roolcount = p2roolcount+r2
        p2rcount.text = "P2 Total count : "+ p2roolcount.toString()
        val tv : TextView = findViewById(R.id.player2_result)
        //tv.setText(r.toString()) //or
        tv.text = "Value : "+r2.toString()
        when (r2) {
            1 -> img2.setImageResource(R.drawable.dice_1)
            2 -> img2.setImageResource(R.drawable.dice_2)
            3 -> img2.setImageResource(R.drawable.dice_3)
            4 -> img2.setImageResource(R.drawable.dice_4)
            5 -> img2.setImageResource(R.drawable.dice_5)
            6 -> img2.setImageResource(R.drawable.dice_6)
        }

    }

    fun upCount(view: View) {

        if ((r1==0) || (r2==0))
        {
            img1.setImageResource(R.drawable.dice_1)
            img2.setImageResource(R.drawable.dice_1)
            p1rcount.text = "1"
            p2rcount.text = "1"
        }
        else if (r1==6 && r2==6)
        {
            p1rcount.text = r1.toString()
            p2rcount.text = r2.toString()
        }

    }
}
