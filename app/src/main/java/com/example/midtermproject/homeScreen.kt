package com.example.midtermproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class homeScreen : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView( //when created, waits for the play button to be pressed to switch fragments to the gameplay
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home_screen, container, false)
        val playGame : Button = view.findViewById(R.id.play)
        playGame.setOnClickListener{
            val fragment = gameScreen()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav,fragment)?.commit()
        }
        return view
    }



}