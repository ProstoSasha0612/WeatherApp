package com.projectapp.weatherapp.data.api

import com.projectapp.weatherapp.domain.location.Location
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CityInfo(
    @SerialName("latitude")
    val lat: Double,
    @SerialName("longitude")
    val lon: Double,
)

fun CityInfo.mapToLocation(): Location {
    return Location(
        latitude = lat,
        longitude = lon
    )
}