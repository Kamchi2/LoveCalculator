package com.example.lovecalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService= RetrofitService()
        App.api = retrofitService.api
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            calculateBtn.setOnClickListener {
                App.api.getCalculateLove(firstNameEd.text.toString(), secondNameEd.text.toString()).enqueue(object :
                    Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if(response.isSuccessful) {
                                Log.e("ololo", "onResponse: ${response.body()?.result}")
                                val model = response.body()
                                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                                intent.putExtra("firstName", firstNameEd.text.toString())
                                intent.putExtra("secondName", secondNameEd.text.toString())
                                intent.putExtra("percentage", model?.percentage.toString())
                                startActivity(intent)
                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("ololo", "onFailure: ${t.message}")
                        }

                    })
            }
        }
    }
}