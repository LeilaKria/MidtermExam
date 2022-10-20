package com.example.midtermexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.midtermexam.databinding.ActivityMainBinding
import com.example.midtermexam.databinding.ActivitySplashScreenBinding
import com.example.midtermexam.databinding.Fragment1Binding

class MainActivity : AppCompatActivity(), View.OnClickListener, PassingDataFragment.RegisterUsernameInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }


    override fun onSendData(name: String) {
        val fragmentManager =supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.fragmentContainer1.id, Fragment2())
        fragmentManager.commit()
    }
    
    override fun onClick(p0: View?) {
        when (p0!!.id){
            (R.id.btn_save)->{
                val fragmentManager =supportFragmentManager.beginTransaction()
                fragmentManager.replace(binding.fragmentContainer2.id, Fragment2())
                fragmentManager.commit()


            }
        }

    }
}