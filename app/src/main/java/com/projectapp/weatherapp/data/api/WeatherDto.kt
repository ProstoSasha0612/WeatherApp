package com.projectapp.weatherapp.data.api

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class WeatherDto(
    @SerialName("hourly")
    val weatherData: WeatherDataDto,
)