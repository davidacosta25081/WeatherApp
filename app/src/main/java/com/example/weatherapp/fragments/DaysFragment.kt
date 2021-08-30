package com.example.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


class DaysFragment : Fragment() {

    private var _binding: FragmentDaysBinding? = null
    private val binding: FragmentDaysBinding get() = _binding!!

    private lateinit var viewmodel: WeatherViewModel
    private lateinit var viewmodel2: WeatherViewModel
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
            WeatherViewModel.WeatherViewModelFactory(WeatherRepo(ApiManager()))
        ).get(WeatherViewModel::class.java)

       //viewmodel.weatherInfo.observe(viewLifecycleOwner){
       //  weatherAdapter.todos = it
      // }

        //Testing Recyclerviews with fake data

        var contactList = mutableListOf(
            Weather(1,"Monday" , 70 ),
            Weather( 2,"Tuesday", 65 ),
            Weather( 3,"Wednesday", 60 ),
            Weather( 4,"Thursday", 55 ),
            Weather(5,"Friday", 56 ),
            Weather( 6,"Saturday", 80),
            Weather(7,"Sunday", 82 )
        )

        weatherAdapter.todos = contactList

    }


private fun setupRecyclerView() = binding.rvWeatherDays.apply{
    weatherAdapter = WeatherAdapter()
    adapter = weatherAdapter
    layoutManager = LinearLayoutManager(requireContext())
}



}