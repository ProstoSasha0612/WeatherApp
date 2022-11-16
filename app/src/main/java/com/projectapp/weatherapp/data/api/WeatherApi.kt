package com.projectapp.weatherapp.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?&hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m,pressure_msl&timezone=auto")
    suspend fun getCurrentWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
    ): WeatherDto

}
