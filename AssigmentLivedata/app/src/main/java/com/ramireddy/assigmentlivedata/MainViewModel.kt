package com.ramireddy.assigmentlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val list = MutableLiveData<MutableList<String>>()

    init{
        val items = list.value
        items?.add("Apple")
        items?.add("Banana")
        items?.add("Orange")
    }

}