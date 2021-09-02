
package com.example.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.api.ApiManager
import com.example.weatherapp.databinding.FragmentDaysBinding
import com.example.weatherapp.repository.WeatherRepo
import com.example.weatherapp.ui.viewmodel.*


class DaysFragment : Fragment() {

    private var _binding: FragmentDaysBinding? = null
    private val binding: FragmentDaysBinding get() = _binding!!

    private lateinit var weatherAdapter: WeatherAdapter
    private lateinit var viewmodel: DailyViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root

    }

/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        viewmodel = ViewModelProvider(
            this,
            DailyViewModelFactory(WeatherRepo(ApiManager()))
        ).get(DailyViewModel::class.java)

        viewmodel.dailyWeatherInfo.observe(viewLifecycleOwner, Observer {
            weatherAdapter.weather = it.data!!.daily
        })


    }

    private fun setupRecyclerView() = binding.rvWeatherDays.apply {
        weatherAdapter = WeatherAdapter()
        adapter = weatherAdapter
        layoutManager = LinearLayoutManager(requireContext())

    }
*/
}
