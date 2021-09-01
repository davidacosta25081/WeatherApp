package com.example.weatherapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.weatherapp.model.CurrentWeatherResponse
import com.example.weatherapp.model.Weather
import com.example.weatherapp.repository.WeatherRepo
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import java.lang.IllegalArgumentException

class WeatherViewModel(private val weatherRepo: WeatherRepo) : ViewModel() {

    private var _weatherInfo: MutableLiveData<Resource<CurrentWeatherResponse>> = MutableLiveData()
    val weatherInfo: LiveData<Resource<CurrentWeatherResponse>> get() = _weatherInfo

    init {
        getWeather()
    }


    private fun getWeather() {
        viewModelScope.launch {
            weatherRepo.getWeather().collect {
                _weatherInfo.postValue(it)
            }
        }
    }
    companion object {
        private val TAG = WeatherViewModel::class.java.name
    }

}

class WeatherViewModelFactory(
   private val weatherRepo: WeatherRepo):
        ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(weatherRepo) as T
    }


}
