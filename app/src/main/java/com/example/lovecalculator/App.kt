package com.example.lovecalculator

import android.app.Application

class App:Application() {
    companion object{
        lateinit var api : LoveApi
    }

}