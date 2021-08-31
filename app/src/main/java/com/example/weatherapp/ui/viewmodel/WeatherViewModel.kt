package com.example.weatherapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.weatherapp.model.Weather
import com.example.weatherapp.repository.WeatherRepo
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class WeatherViewModel(private val weatherRepo: WeatherRepo) : ViewModel() {

    private var _weatherInfo: MutableLiveData<List<Weather>> = MutableLiveData()
    val weatherInfo: LiveData<List<Weather>?> get() = _weatherInfo

    init {
        getWeather()
    }

    private fun getWeather() {
        Log.d(TAG, "getWeather() called")
        viewModelScope.launch() {
            val weatherRepo = weatherRepo.getWeather()
            _weatherInfo.postValue(weatherRepo)
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
