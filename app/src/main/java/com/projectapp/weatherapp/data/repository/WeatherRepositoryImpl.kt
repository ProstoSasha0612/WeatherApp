package com.projectapp.weatherapp.data.repository

import com.projectapp.weatherapp.data.api.CityApi
import com.projectapp.weatherapp.data.api.WeatherApi
import com.projectapp.weatherapp.data.api.mapToLocation
import com.projectapp.weatherapp.data.mappers.toWeatherInfo
import com.projectapp.weatherapp.domain.location.Location
import com.projectapp.weatherapp.domain.repository.WeatherRepository
import com.projectapp.weatherapp.domain.weather.Resource
import com.projectapp.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val cityApi: CityApi,
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            val weatherInfo = api.getCurrentWeatherData(lat, long).toWeatherInfo()
            Resource.Success(weatherInfo)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred!")
        }
    }

    override suspend fun getCityCoordinates(cityName: String): Resource<Location> {
        return try {
            val cityInfo = cityApi.getCityCoordinates(cityName)[0]
            Resource.Success(cityInfo.mapToLocation())
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred!")
        }
    }

    override suspend fun getCityByCoordinates(location: Location): Resource<String> {
        return try {
            val name = cityApi.getCityByCoordinates(location.latitude, location.longitude)[0].name
            Resource.Success(name)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred!")
        }
    }
}