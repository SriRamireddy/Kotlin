package com.ramireddy.kotlincalenderevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.time.DayOfWeek
import java.time.MonthDay
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun calendarEvent(view: View) {
        val c : Calendar = Calendar.getInstance()
        val intent = Intent(Intent.ACTION_EDIT)
        intent.setType("vnd.android.cursor.item/event")
        intent.putExtra("beginTime",c.timeInMillis+(95*60*1000))
        intent.putExtra("endTime",c.timeInMillis+(60*60*1000))
        intent.putExtra("title","Kotlin Class")
        startActivity(intent)
    }

}
