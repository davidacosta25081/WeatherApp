package com.example.weatherapp.model

import com.squareup.moshi.JsonClass
import java.security.CodeSigner
import java.util.*
import java.util.jar.Attributes


@JsonClass(generateAdapter = true)
data class CurrentWeatherResponse(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    )