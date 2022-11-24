package com.projectapp.weatherapp.presentation.view.state

import com.projectapp.weatherapp.domain.location.Location
import com.projectapp.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val cityName: String = "...",
    val currentLocation: Location? = null,
    val isLoading: Boolean? = false,
    val error: String? = null,
)
