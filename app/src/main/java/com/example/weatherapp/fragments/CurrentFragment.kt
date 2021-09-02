package com.example.weatherapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.api.ApiManager
import com.example.weatherapp.databinding.FragmentCurrentBinding
import com.example.weatherapp.repository.WeatherRepo
import com.example.weatherapp.ui.viewmodel.WeatherViewModel
import com.example.weatherapp.ui.viewmodel.WeatherViewModelFactory


class CurrentFragment : Fragment() {

    private var _binding: FragmentCurrentBinding? = null
    private val binding: FragmentCurrentBinding get() = _binding!!

    private lateinit var viewmodel: WeatherViewModel
    // private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewmodel = ViewModelProvider(
            this,
            WeatherViewModelFactory(WeatherRepo(ApiManager()))
        ).get(WeatherViewModel::class.java)

        viewmodel.weatherInfo.observe(viewLifecycleOwner, Observer {
            with(binding) {
                tvTemperature.text = it.data!!.main.temp.toString()
                tvDescription.text = it.data!!.weather[0].description
                tvTemperatureHigh.text = it.data!!.main.tempMax.toString()
                tvTemperatureLow.text = it.data!!.main.tempMin.toString()
            }
        })
    }
}