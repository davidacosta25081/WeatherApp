package com.example.weatherapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Main(
    val temp : Double ,
    val humidity: Int ,
    @get:Json(name="temp_min")
    val tempMin: Double,
    @get:Json(name = "temp_max")
    val tempMax: Double
    )
