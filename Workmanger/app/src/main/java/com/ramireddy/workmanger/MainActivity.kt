package com.ramireddy.workmanger

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendnotification(view: View) {

        val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            val notificationChannel : NotificationChannel = NotificationChannel("NOTIFY","MyChannel",NotificationManager.IMPORTANCE_HIGH)

        }

    }
}
