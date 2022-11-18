package com.projectapp.weatherapp.data.api

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CityName(
    @SerialName("name")
    val name: String,
)