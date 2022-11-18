package com.projectapp.weatherapp.data.api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CityApi {

    @GET("v1/city")
    suspend fun getCityCoordinates(
        @Header("x-api-key: $API_KEY")
        @Query("name") cityName: String,
    ): List<CityInfo>

    @GET("v1/reversegeocoding")
    suspend fun getCityByCoordinates(
        @Header("x-api-key: $API_KEY")
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
    ): List<CityName>

}

private const val API_KEY = "dj7C6hW3G3xUeB+A5WAdXg==JyLgdBkogJ6Jt8mE"