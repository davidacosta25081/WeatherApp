package com.example.weatherapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Temp(
    val max: Double,
    val min: Double,
    val day: Double,
    val eve: Double,
)