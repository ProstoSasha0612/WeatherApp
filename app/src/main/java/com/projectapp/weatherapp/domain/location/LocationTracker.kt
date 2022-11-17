package com.projectapp.weatherapp.domain.location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}