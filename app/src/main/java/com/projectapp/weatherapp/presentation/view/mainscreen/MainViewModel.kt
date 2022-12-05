package com.projectapp.weatherapp.presentation.view.mainscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projectapp.weatherapp.domain.location.Location
import com.projectapp.weatherapp.domain.location.LocationTracker
import com.projectapp.weatherapp.domain.repository.WeatherRepository
import com.projectapp.weatherapp.domain.weather.Resource
import com.projectapp.weatherapp.presentation.view.state.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
) : ViewModel() {

    var state = MutableStateFlow(WeatherState())
        private set

    fun loadCurrentCityWeatherInfo() {
        state.value = state.value.copy(isLoading = true)
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                loadWeatherInfo(location)
                loadCityName(location)
            } ?: kotlin.run {
                state.value =
                    state.value.copy(error = "Couldn't retrieve location. Make sure to grant permission and enable GPS.")
            }
        }
    }

    fun loadSelectedCityWeatherInfo(cityName:String){
        viewModelScope.launch {
            val location = repository.getCityCoordinates(cityName)
            when(location){
                is Resource.Success ->{
                    loadWeatherInfo(requireNotNull(location.data))
                }
                is Resource.Error -> {
                    state.value = state.value.copy(error = "Can't retrieve weather info from selected city: $cityName")
                }
            }
        }
    }

    private fun loadWeatherInfo(location: Location) {
        viewModelScope.launch {
            state.value = state.value.copy(isLoading = true)
            val weatherInfo =
                repository.getWeatherData(location.latitude, location.longitude)
            state.value = when (weatherInfo) {
                is Resource.Success -> {
                    state.value.copy(isLoading = false,
                        weatherInfo = weatherInfo.data,
                        currentLocation = Location(latitude = location.latitude,
                            longitude = location.longitude))
                }
                is Resource.Error -> {
                    state.value.copy(isLoading = false, error = weatherInfo.message)
                }
            }
        }
    }

    private fun loadCityName(location: Location) {
        viewModelScope.launch {
            repository.getCityByCoordinates(location).let { result ->
                state.value = when (result) {
                    is Resource.Success -> {
                        state.value.copy(cityName = requireNotNull(result.data))
                    }
                    is Resource.Error -> {
                        Log.d("MYTAG", result.message ?: "Name loading error")
                        state.value.copy(error = result.message ?: "Name loading error")
                    }
                }
            }
        }
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