package com.ramireddy.kotlinimplicitintent

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openweb(view: View) {
        val i = Intent()
        i.setAction(ACTION_VIEW)
        i.setData(Uri.parse("https://SriRamireddy.github.io"))
        startActivity(i)

    }
}
