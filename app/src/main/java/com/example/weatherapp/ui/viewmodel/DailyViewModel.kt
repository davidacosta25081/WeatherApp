package com.example.weatherapp.ui.viewmodel


import androidx.lifecycle.*
import com.example.weatherapp.model.DailyWeather
import com.example.weatherapp.repository.WeatherRepo
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


class DailyViewModel(private val weatherRepo: WeatherRepo) : ViewModel() {

    private var _dailyWeatherInfo: MutableLiveData<Resource<DailyWeather>> = MutableLiveData()
    val dailyWeatherInfo: LiveData<Resource<DailyWeather>> get() = _dailyWeatherInfo

    init {
        getDailyWeather()
    }

    private fun getDailyWeather() {
        viewModelScope.launch {
            weatherRepo.getDailyWeather().collect {
                _dailyWeatherInfo.postValue(it)
            }
        }
    }
    companion object {
        private val TAG = DailyViewModel::class.java.name
    }

}

class DailyViewModelFactory(
    private val weatherRepo: WeatherRepo):
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DailyViewModel(weatherRepo) as T
    }


}

