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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
) : ViewModel() {

    private val _mutableWeatherState = MutableStateFlow<WeatherState>(WeatherState.Loading())
    val weatherState: StateFlow<WeatherState> get() = _mutableWeatherState
    private val _mutableCityName = MutableStateFlow<String>("...")
    val cityName: StateFlow<String> get() = _mutableCityName

    fun loadWeatherInfo() {
        _mutableWeatherState.value = WeatherState.Loading()
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                val result = repository.getWeatherData(location.latitude, location.longitude)
                loadCityName(location)
                _mutableWeatherState.value = when (result) {
                    is Resource.Success -> {
                        WeatherState.Success(requireNotNull(result.data))
                    }
                    is Resource.Error -> {
                        WeatherState.Error(result.message)
                    }
                }
            } ?: kotlin.run {
                _mutableWeatherState.value =
                    WeatherState.Error("Couldn't retrieve location. Make sure to grant permission and enable GPS.")
            }
        }
    }


    private fun loadCityName(location: Location) {
        viewModelScope.launch {
            repository.getCityByCoordinates(location).let { result ->
                when (result) {
                    is Resource.Success -> {
                        _mutableCityName.value = requireNotNull(result.data)
                    }
                    is Resource.Error -> {
                        Log.d("MYTAG", result.message ?: "NO data about error")
                        _mutableCityName.value = result.message ?: "Name loading error"
                    }
                }
            }
        }
    }

}