package com.ramireddy.recyclerdiffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    val datasource : MutableList<String> = ArrayList<String>()
    lateinit var rc : RecyclerView
    val adapter1 = MyAdapterCl(datasource)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc = findViewById(R.id.recycler)
        rc.layoutManager = LinearLayoutManager(this)
        rc.adapter = adapter1
        initData()
    }
    private fun initData() {
        for (i in 0..1){
            datasource.add(UUID.randomUUID().toString())
        }
    }

    fun update(view: View) {
        val newdata = ArrayList<String>()
        for(i in 0..2){
            newdata.add(UUID.randomUUID().toString())
            adapter1.updateItem(newdata)
            rc.smoothScrollToPosition(adapter1.itemCount-1)
        }
    }
    fun insert(view: View) {
        val newData = ArrayList<String>()
        for (i in 0..2){
            newData.add(UUID.randomUUID().toString())
            adapter1.insertItem(newData)
            rc.smoothScrollToPosition(adapter1.itemCount-1)
        }
    }
}
