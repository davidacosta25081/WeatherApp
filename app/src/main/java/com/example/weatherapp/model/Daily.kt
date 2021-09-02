package com.example.weatherapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Daily(
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val humidity: Int,
    val moon_phase: Double,
    val moonrise: Int,
    val moonset: Int,
    val pop: Double,
    val pressure: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,

)