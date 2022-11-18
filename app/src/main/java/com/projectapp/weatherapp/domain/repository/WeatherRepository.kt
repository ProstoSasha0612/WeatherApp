package com.projectapp.weatherapp.domain.repository

import com.projectapp.weatherapp.domain.location.Location
import com.projectapp.weatherapp.domain.weather.Resource
import com.projectapp.weatherapp.domain.weather.WeatherData
import com.projectapp.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>

    suspend fun getCityCoordinates(cityName: String): Location

    suspend fun getCityByCoordinates(location: Location): String
}