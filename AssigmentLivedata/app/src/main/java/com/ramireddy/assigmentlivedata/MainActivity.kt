package com.ramireddy.assigmentlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ramireddy.assigmentlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var list : MutableList<String> = mutableListOf()

    // to retrive values from the list
    val index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        initlist()

        binding.updateList.setOnClickListener { updatelist() }

        binding.next.setOnClickListener {  }

    }

    private fun updatelist() {

        for ( i in 0..9){
            list.add("grape ${i+1}")
        }
    }
    private fun initlist() {
        list = mutableListOf("Apple","Banana")
        displaywords(index)
       displayvalues()
    }

    private fun displayvalues(){
        binding.listDisplay.text =""
        for ( i in list){
            binding.listDisplay.append(i+" ")
        }
    }

    private fun displaywords(i : Int){
        binding.textView2.text = list.get(i)

    }


}
