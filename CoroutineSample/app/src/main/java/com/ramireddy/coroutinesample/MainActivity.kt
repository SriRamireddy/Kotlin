package com.ramireddy.coroutinesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity()  {

    lateinit var tx : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tx = findViewById(R.id.text1)
            waitsample()
    }

    private fun waitsample() = runBlocking {
        val starttime = System.currentTimeMillis()
        val d = async { calculateHardThings(10) }
        val d1 = async { calculateHardThings(20) }
        val d2 = async { calculateHardThings(30) }
        val sum = d.await() + d1.await()+ d2.await()
        val endtime = System.currentTimeMillis()
        val tim =endtime - starttime
        Toast.makeText(this@MainActivity,""+sum+"\n"+tim,Toast.LENGTH_LONG).show()
    }

    private fun calculateHardThings(i: Int)  : Int {

        return i*10
    }

    private fun printDelay1() = runBlocking {
        Toast.makeText(this@MainActivity,"before",Toast.LENGTH_LONG).show()
        launch(Dispatchers.Main) {
            printDelay()
        }
    }

    suspend fun printDelay(){
        delay(1000)
        tx.text = "After one sec"
    }

}
