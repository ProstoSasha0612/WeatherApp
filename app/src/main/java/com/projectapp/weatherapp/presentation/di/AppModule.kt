@file:OptIn(ExperimentalSerializationApi::class)

package com.projectapp.weatherapp.presentation.di

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.projectapp.weatherapp.data.api.CityApi
import com.projectapp.weatherapp.data.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @AppScope
    fun provideWeatherApi(): WeatherApi {

        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        val httpClient = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl(WEATHER_API_BASE_URL)
            .client(httpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()

        return retrofit.create(WeatherApi::class.java)

    }

    @Provides
    @AppScope
    fun provideCityApi(): CityApi {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        return Retrofit.Builder().baseUrl(CITY_API_BASE_URL)

            .addConverterFactory(json.asConverterFactory(contentType))
            .client(httpClient)
            .build()
            .create()
    }

    @Provides
    @AppScope
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }

    private const val WEATHER_API_BASE_URL = "https://api.open-meteo.com/"
    private const val CITY_API_BASE_URL = "https://api.api-ninjas.com/"
}

annotation class AppScope