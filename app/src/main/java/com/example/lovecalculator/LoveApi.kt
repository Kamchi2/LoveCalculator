package com.example.lovecalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getCalculateLove(
        @Query("fname") firstName: String,
        @Query("sname") second: String,
        @Header("X-RapidAPI-Key") key: String = "809ae668dfmshcb275dbb883bf4fp176b48jsn7e6b2ce3a0db",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>

}