package com.projectapp.weatherapp.domain.api

import retrofit2.http.Query

interface WeatherApi {

    suspend fun getCurrentWeatherData(
        @Query("lat") lat:Double,
        @Query("lon")long:Double
    )

}