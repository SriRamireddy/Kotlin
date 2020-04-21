package com.ramireddy.recyclerviewkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerview : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview = findViewById(R.id.recycler)
        displayData()
    }

    private fun displayData(){
        RecyclerAdapter(this)
    }

    class RecyclerAdapter(val context : Context) : RecyclerView.Adapter<RecyclerVieHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerVieHolder {

            val v : View = LayoutInflater.from(context).inflate(R.layout.row,parent,false)
            return RecyclerVieHolder(v)
        }


        override fun onBindViewHolder(holder: RecyclerVieHolder, position: Int) {
            holder.text1.text = "Name "+position
            holder.text2.text = "Age "+position
            holder.text3.text = "Branch "+position
        }

        override fun getItemCount(): Int {

            return 10
        }

    }

    class RecyclerVieHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val text1 : TextView = itemView.findViewById(R.id.textView)
        val text2 : TextView = itemView.findViewById(R.id.textView2)
        val text3 : TextView = itemView.findViewById(R.id.textView3)
    }
}
