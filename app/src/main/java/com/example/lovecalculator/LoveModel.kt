package com.example.lovecalculator

import com.google.gson.annotations.SerializedName


data class LoveModel (
    @SerializedName("fName")
    val firstName: String,
    @SerializedName("sName")
    val secondName: String,
    val percentage: String,
    val result: String
)
