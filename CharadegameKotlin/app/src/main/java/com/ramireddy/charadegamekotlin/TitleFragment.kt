package com.ramireddy.charadegamekotlin

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_title, container, false)


        val btn_play = v.findViewById<Button>(R.id.btn_ply)
        btn_play.setOnClickListener {
            v.findNavController().navigate(R.id.action_titleFragment_to_gameFrag)
        }

        return v
    }
}
