package com.projectapp.weatherapp.presentation.view.mainscreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projectapp.weatherapp.data.api.CityName
import com.projectapp.weatherapp.domain.location.Location
import com.projectapp.weatherapp.domain.location.LocationTracker
import com.projectapp.weatherapp.domain.repository.WeatherRepository
import com.projectapp.weatherapp.domain.weather.Resource
import com.projectapp.weatherapp.presentation.view.state.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadCurrentCityWeatherInfo() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                loadWeatherInfo(location)
                loadCityName(location)
            } ?: kotlin.run {
                state =
                    state.copy(error = "Couldn't retrieve location. Make sure to grant permission and enable GPS.")
            }
        }
    }

    fun loadWeatherInfo(location: Location) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val weatherInfoResource =
                repository.getWeatherData(location.latitude, location.longitude)
            state = when (weatherInfoResource) {
                is Resource.Success -> {
                    state.copy(isLoading = false,
                        weatherInfo = weatherInfoResource.data,
                        currentLocation = Location(latitude = location.latitude,
                            longitude = location.longitude))
                }
                is Resource.Error -> {
                    state.copy(isLoading = false, error = weatherInfoResource.message)
                }
            }
        }
    }

    fun loadCityName(location: Location) {
        viewModelScope.launch {
            repository.getCityByCoordinates(location).let { result ->
                state = when (result) {
                    is Resource.Success -> {
                        state.copy(cityName = requireNotNull(result.data))
                    }
                    is Resource.Error -> {
                        Log.d("MYTAG", result.message ?: "Name loading error")
                        state.copy(error = result.message ?: "Name loading error")
                    }
                }
            }
        }
    }

    private fun setUpStateListener() {

    }

//
//    fun loadWeatherInfo(location: Location) {
//        loadCityName(location)
//        _mutableWeatherState.value = when (result) {
//            is Resource.Success -> {
//                WeatherState.Success(requireNotNull(result.data))
//            }
//            is Resource.Error -> {
//                WeatherState.Error(result.message)
//            }
//        }
//    }


}