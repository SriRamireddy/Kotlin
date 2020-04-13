package com.ramireddy.charadegamekotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

/**
 * A simple [Fragment] subclass.
 */
class ScoreFrag : Fragment() {

    lateinit var gameViewModel: GameViewModel
    lateinit var score_display : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var v = inflater.inflate(R.layout.fragment_score, container, false)
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        score_display = v.findViewById<TextView>(R.id.total_score)

        score_display.text = gameViewModel.score.toString()
        return v

    }


}
