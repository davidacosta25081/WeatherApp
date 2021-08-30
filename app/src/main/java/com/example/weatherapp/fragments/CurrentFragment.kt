package com.example.weatherapp.fragments

import android.annotation.SuppressLint
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
import com.example.weatherapp.model.Weather
import com.example.weatherapp.repository.WeatherRepo
import com.example.weatherapp.ui.viewmodel.WeatherAdapter
import com.example.weatherapp.ui.viewmodel.WeatherViewModel


class CurrentFragment : Fragment() {

    private var _binding: FragmentCurrentBinding? = null
    private val binding: FragmentCurrentBinding get() = _binding!!

    private lateinit var viewmodel: WeatherViewModel
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrentBinding.inflate(inflater, container, false)
        //setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val number = "75"
        binding.tvTemperature.text = number

    }

}