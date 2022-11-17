package com.projectapp.weatherapp.data.repository

import com.projectapp.weatherapp.data.api.WeatherApi
import com.projectapp.weatherapp.data.mappers.toWeatherInfo
import com.projectapp.weatherapp.domain.repository.WeatherRepository
import com.projectapp.weatherapp.domain.weather.Resource
import com.projectapp.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            val weatherInfo = api.getCurrentWeatherData(lat, long).toWeatherInfo()
            Resource.Success(weatherInfo)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?:"An unknown error occurred!")
        }
    }
}