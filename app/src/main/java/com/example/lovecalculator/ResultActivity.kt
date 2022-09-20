package com.example.lovecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstNameTv.text = intent.getStringExtra("firstName")
        binding.secondNameTv.text = intent.getStringExtra("secondName")
        binding.percentage.text = intent.getStringExtra("percentage")
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            returnBtn.setOnClickListener{
                var intent = Intent(this@ResultActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}