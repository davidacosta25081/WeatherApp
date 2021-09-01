package com.example.weatherapp.repository

import android.util.Log
import com.example.weatherapp.api.ApiManager
import com.example.weatherapp.model.CurrentWeatherResponse
import com.example.weatherapp.model.Weather
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException

class WeatherRepo(private val apiManager: ApiManager) {

    fun getWeather() = flow {

        val resource = try {
            val response = apiManager.getWeather()
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error(response.errorBody().toString())
            }
        } catch (ex: Exception) {
            Log.d(TAG, ex.toString())
            Resource.Error(ex.toString())
        }

        emit(resource)
    }


    companion object {
        private val TAG = WeatherRepo::class.java.name
    }
}