package com.example.weatherapp.api

import com.example.weatherapp.model.Weather
import com.example.weatherapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {


    @GET("/todos")
    suspend fun getWeather(
    ): Response<List<Weather>>

}



/*

@GET("data/2.5/onecall")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double ,
        @Query("appid") APIKEY: String
    ): Response<List<Weather>>
 */