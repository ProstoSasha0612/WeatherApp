package com.projectapp.weatherapp.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {

    @GET("v1/city")
    suspend fun getCityCoordinates(
        @Query("name") cityName: String,
    ): List<CityInfo>

    @GET("v1/reversegeocoding")
    suspend fun getCityByCoordinates(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
    ): List<CityName>

}
