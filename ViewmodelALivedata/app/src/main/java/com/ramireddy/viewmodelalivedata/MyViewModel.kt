package com.ramireddy.viewmodelalivedata

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel()
{
    var r : Int = 0
    init {
        grtrand()
    }
    fun grtrand():Int{
        return (1..100).random()

    }
}