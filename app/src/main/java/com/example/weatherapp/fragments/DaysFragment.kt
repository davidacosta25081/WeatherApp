package com.example.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.api.ApiManager
import com.example.weatherapp.databinding.FragmentCurrentBinding
import com.example.weatherapp.databinding.FragmentDaysBinding
import com.example.weatherapp.model.Weather
import com.example.weatherapp.repository.WeatherRepo
import com.example.weatherapp.ui.viewmodel.WeatherAdapter
import com.example.weatherapp.ui.viewmodel.WeatherViewModel
import com.example.weatherapp.ui.viewmodel.WeatherViewModelFactory


class DaysFragment : Fragment() {

    private var _binding: FragmentDaysBinding? = null
    private val binding: FragmentDaysBinding get() = _binding!!

    private lateinit var viewmodel: WeatherViewModel
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDaysBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = ViewModelProvider(
            this,
            WeatherViewModelFactory(WeatherRepo(ApiManager()))
        ).get(WeatherViewModel::class.java)

        //  viewmodel.weatherInfo.observe(viewLifecycleOwner, Observer {
        //   weatherAdapter.weather = it
        //  })

        //Testing Recyclerviews with fake data
        var exampleList = mutableListOf(
            Weather(1, 70, "Monday", true),
            Weather(1, 65, "Tuesday", true),
            Weather(1, 50, "Wednesday", true),
            Weather(1, 55, "Thursday", true),
            Weather(1, 67, "Friday", true),
            Weather(1, 80, "Saturday", true),
            Weather(1, 90, "Sunday", true)
        )
        weatherAdapter.weather = exampleList

    }

    private fun setupRecyclerView() = binding.rvWeatherDays.apply {
        weatherAdapter = WeatherAdapter()
        adapter = weatherAdapter
        layoutManager = LinearLayoutManager(requireContext())

    }

}
