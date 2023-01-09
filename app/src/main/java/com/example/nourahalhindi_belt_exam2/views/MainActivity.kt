package com.example.nourahalhindi_belt_exam2.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nourahalhindi_belt_exam2.R
import com.example.nourahalhindi_belt_exam2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
        btnAPI.setOnClickListener{
            val intent=Intent(this@MainActivity,API_Activity::class.java)
            startActivity(intent)
        }
        btnDB.setOnClickListener{
            val intent=Intent(this@MainActivity,DB_Activity::class.java)
            startActivity(intent)
        }
        }

        }
    }
