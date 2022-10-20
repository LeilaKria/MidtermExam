package com.example.midtermexam

import Fragment2
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import com.example.midtermexam.databinding.ActivityMainBinding
import com.example.midtermexam.databinding.ActivitySplashScreenBinding
import com.example.midtermexam.databinding.Fragment1Binding

class MainActivity : AppCompatActivity(), Fragment1.RegisterUsernameInterface {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.FragmentCon1.id, Fragment1())
        fragmentManager.commit()

    }

    override fun onSendData() {
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.FragmentCon2.id, Fragment2())
        fragmentManager.commit()
    }

}