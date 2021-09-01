package com.example.weatherapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Main(
    val temp : Long ,
    val humidity: Int
    )
