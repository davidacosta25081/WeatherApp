package com.example.weatherapp.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Weather(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean



)