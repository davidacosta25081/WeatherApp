package com.example.weatherapp.api

import com.example.weatherapp.model.CurrentWeatherResponse
import com.example.weatherapp.model.Weather
import com.example.weatherapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") APIKEY: String
    ): Response<CurrentWeatherResponse>


}