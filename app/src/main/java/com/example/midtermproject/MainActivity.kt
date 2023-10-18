package com.example.midtermproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.midtermproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { //runs the main program and holds a fragment view to view the fragments
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //initiates binding
        val view = binding.root
        setContentView(view)
        supportFragmentManager.beginTransaction().replace(R.id.nav,homeScreen()).commit()

    }
}