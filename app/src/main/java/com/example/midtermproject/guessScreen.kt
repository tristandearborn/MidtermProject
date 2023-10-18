package com.example.midtermproject

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import kotlin.random.Random
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.midtermproject.model.ViewModelShared

class guessScreen : Fragment() { //implements shared view model
    val sharedViewModel: ViewModelShared by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView( //runs the game by creating a random number from 1 to 100, then when the user inputs a guess, tells if too low or high, or if right
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_guess_screen, container, false)
        var attemptCount = 0
        var guessNum = view.findViewById<EditText>(R.id.guess)
        guessNum.setText("1")
        val minus: ImageButton = view.findViewById(R.id.minus)
        minus.setOnClickListener {
            guessNum = view.findViewById<EditText>(R.id.guess)
            var currentGuess = guessNum.text.toString().toInt()
            if (currentGuess > 1) {
                currentGuess -= 1
                guessNum.setText(currentGuess.toString())
            }
        }
        val plus: ImageButton = view.findViewById(R.id.plus)
        plus.setOnClickListener {
            guessNum = view.findViewById<EditText>(R.id.guess)
            var currentGuess = guessNum.text.toString().toInt()
            if (currentGuess < 100){
                currentGuess+=1
                guessNum.setText((currentGuess.toString()))
            }
        }
        val rng = Random.nextInt(1, 101)
        val ok: Button = view.findViewById(R.id.okButton)
        ok.setOnClickListener {
            guessNum = view.findViewById<EditText>(R.id.guess)
            var currentGuess = guessNum.text.toString().toInt()
            if (currentGuess == rng) {
                val fragment = homeScreen()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.nav, fragment)?.commit()
            } else {

                val wrong: MediaPlayer = MediaPlayer.create(activity, R.raw.buzz)
                wrong.start()
                attemptCount += 1
                sharedViewModel.attemptCount = attemptCount.toString()
                if (currentGuess > rng){
                    Toast.makeText(activity,"Guess too high!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(activity,"Guess too low!",Toast.LENGTH_LONG).show();
                }
                val fragment = attemptScreen()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.attemptsFrag,fragment)?.commit()

            }
        }
        return view
    }

}