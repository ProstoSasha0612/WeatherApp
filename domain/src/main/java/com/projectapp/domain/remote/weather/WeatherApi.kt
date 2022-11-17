package com.projectapp.domain.remote.weather

import retrofit2.http.Query

interface WeatherApi {

    suspend fun getCurrentWeatherData(
        @Query("lat") lat:Double,
        @Query("lon")long:Double
    )

}