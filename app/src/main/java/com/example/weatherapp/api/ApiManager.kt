package com.example.weatherapp.api

import com.example.weatherapp.model.Weather
import com.example.weatherapp.utils.Constants.Companion.API_KEY
import retrofit2.Response

class ApiManager {


    private val weatherService: WeatherService
    private val retrofit = RetrofitInstance.providesRetrofit()

    init {

        weatherService = retrofit.create(WeatherService::class.java)
    }

    suspend fun getWeather() : Response<List<Weather>> {
        return weatherService.getWeather()
    }

}





