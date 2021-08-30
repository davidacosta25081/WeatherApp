package com.example.weatherapp.repository

import android.util.Log
import com.example.weatherapp.api.ApiManager
import com.example.weatherapp.model.Weather
import com.example.weatherapp.utils.Resource
import java.io.IOException

class WeatherRepo(private val apiManager: ApiManager) {


    suspend fun getWeather(): List<Weather> {
        return try {
            val response = apiManager.getWeather()
            if (response.isSuccessful && response.body() != null) {
                response.body()!!
            } else {
                emptyList()
            }
        } catch (ex: Exception) {
            Log.d(TAG, ex.toString())
            emptyList()
        }
    }


    companion object {
        private val TAG = WeatherRepo::class.java.name
    }
}