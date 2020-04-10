package com.ramireddy.tabskotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

/**
 * A simple [Fragment] subclass.
 */
class Tab1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_tab1, container, false)
        val btn : Button = v.findViewById(R.id.call)

        btn.setOnClickListener { makecall() }

        return v
    }

    private fun makecall() {
        val toast : Toast = Toast.makeText(activity,"hello",Toast.LENGTH_LONG)
        toast.show()
    }


}
