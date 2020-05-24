package com.ramireddy.recyclerdiffutil

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil (private val oldList : List<String>,private val newList : List<String>):DiffUtil.Callback()
{
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun getOldListSize(): Int {
        return oldListSize
    }

    override fun getNewListSize(): Int {

        return newListSize

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return oldList[oldItemPosition] == newList[newItemPosition]

    }

}