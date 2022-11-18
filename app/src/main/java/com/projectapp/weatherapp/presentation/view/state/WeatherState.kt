package com.projectapp.weatherapp.presentation.view.state

import com.projectapp.weatherapp.domain.weather.WeatherInfo

sealed class WeatherState(
//    val weatherInfo: WeatherInfo? = null,
//    val isLoading: Boolean? = false,
//    val error: String? = null,
) {
    class Success(val weatherInfo: WeatherInfo) : WeatherState()
    class Loading : WeatherState()
    class Error(val message: String?) : WeatherState()
}
