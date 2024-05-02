package com.example.lab3.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3.R
import com.example.lab3.fragment.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_view, LoginFragment()).commit()

    }
}