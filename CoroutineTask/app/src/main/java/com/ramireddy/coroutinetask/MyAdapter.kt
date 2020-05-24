package com.ramireddy.coroutinetask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(
    mainActivity: MainActivity,
    country: MutableList<String>,
    countryFlag: MutableList<String>
) : RecyclerView.Adapter<MyAdapter.MyViewClass>()
{
    val ct : Context = mainActivity
    val contryname : MutableList<String> = country
    val contryflag : MutableList<String> = countryFlag
    class MyViewClass(v : View) : RecyclerView.ViewHolder(v)
    {
        val cname : TextView = v.findViewById(R.id.country_name)
        val cFlag : ImageView = v.findViewById(R.id.country_flag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewClass {
        //get xml file

        val view : View = LayoutInflater.from(ct).inflate(R.layout.userdesign,parent,false)
        return MyViewClass(view)
    }

    override fun getItemCount(): Int {
       return contryname.size
    }
    override fun onBindViewHolder(holder: MyAdapter.MyViewClass, position: Int) {
        holder.cname.text = contryname.get(position)
        Picasso.get().load(contryflag.get(position)).into(holder.cFlag)
    }

}