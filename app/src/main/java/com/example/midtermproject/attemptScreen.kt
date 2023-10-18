package com.example.midtermproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.midtermproject.model.ViewModelShared


class attemptScreen : Fragment() {
    val sharedViewModel: ViewModelShared by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView( //replaces the number of attempts with the current number of attempts
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_attempt_screen, container, false)
        val receivedText = sharedViewModel.attemptCount
        var s = "Number of Attempts: $receivedText"
        var text = view.findViewById<TextView>(R.id.attempts)
        text.text = s
        return view
    }

}