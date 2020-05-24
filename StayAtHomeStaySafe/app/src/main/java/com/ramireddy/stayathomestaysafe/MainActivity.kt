package com.ramireddy.stayathomestaysafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Thread.sleep(5000)
        Handler().postDelayed(
            {
                val i = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(i)
                finish()
            }, 3000)
    }
}
