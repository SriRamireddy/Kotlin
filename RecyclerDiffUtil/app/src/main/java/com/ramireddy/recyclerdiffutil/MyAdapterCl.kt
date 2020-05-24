package com.ramireddy.recyclerdiffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MyAdapterCl (private val datasource : MutableList<String>): RecyclerView.Adapter<MyAdapterCl.MyInnerClass>()
{
    class MyInnerClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textv : TextView
        init {
            textv = itemView.findViewById(R.id.text1)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterCl.MyInnerClass
    {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.data,parent,false)
        return MyInnerClass(v)
    }

    override fun getItemCount(): Int
    {
        return datasource.size
    }
    override fun onBindViewHolder(holder: MyAdapterCl.MyInnerClass, position: Int) {

        holder.textv .text = datasource.get(position)
    }
    fun insertItem(newList: List<String>)
    {
        val difutil = MyDiffUtil(datasource,newList)
        val diffResult : DiffUtil.DiffResult = DiffUtil.calculateDiff(difutil)
        datasource.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
    fun updateItem(newList: List<String>){
        val diffutilup = MyDiffUtil(datasource,newList)
        val diffresult : DiffUtil.DiffResult = DiffUtil.calculateDiff(diffutilup)
        datasource.clear()
        datasource.addAll(newList)
        diffresult.dispatchUpdatesTo(this)
    }
}