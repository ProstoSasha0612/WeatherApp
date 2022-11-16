package com.projectapp.weatherapp.data.api

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
class WeatherDataDto(
    @SerialName("time")
    val times: List<String>,
    @SerialName("temperature_2m")
    val temperatures: List<Double>,
    @SerialName("weathercode")
    val weatherCodes: List<Int>,
    @SerialName("windspeed_10m")
    val windSpeeds: List<Double>,
    @SerialName("relativehumidity_2m")
    val humidities: List<Int>,
    @SerialName("pressure_msl")
    val pressures: List<Double>,
)