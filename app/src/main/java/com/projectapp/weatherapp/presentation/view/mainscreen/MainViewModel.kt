package com.projectapp.weatherapp.presentation.view.mainscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projectapp.weatherapp.domain.location.Location
import com.projectapp.weatherapp.domain.location.LocationTracker
import com.projectapp.weatherapp.domain.repository.WeatherRepository
import com.projectapp.weatherapp.domain.weather.Resource
import com.projectapp.weatherapp.presentation.view.event.EventHandler
import com.projectapp.weatherapp.presentation.view.event.MainEvent
import com.projectapp.weatherapp.presentation.view.state.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
) : ViewModel(), EventHandler<MainEvent> {

    private val _state = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> get() = _state

    override fun obtainEvent(event: MainEvent) {
        when (event) {
            is MainEvent.LoadCurrentLocationWeather -> loadCurrentCityWeatherInfo()
            is MainEvent.CityChanged -> loadSelectedCityWeatherInfo(event.newCity)
            is MainEvent.WeekForecastNavigate -> navigateToWeekForecastScreen(event.onNavigateToWeekForecast)
        }
    }

    private fun navigateToWeekForecastScreen(onNavigateToWeekForecast: () -> Unit) {
        onNavigateToWeekForecast()
    }

    private fun loadCurrentCityWeatherInfo() {
        _state.value = _state.value.copy(isLoading = true)
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                loadWeatherInfo(location)
                loadCityName(location)
            } ?: kotlin.run {
                _state.value =
                    _state.value.copy(error = "Couldn't retrieve location. Make sure to grant permission and enable GPS.")
            }
        }
    }

    private fun loadSelectedCityWeatherInfo(cityName: String) {
        viewModelScope.launch {
            when (val location = repository.getCityCoordinates(cityName)) {
                is Resource.Success -> {
                    loadWeatherInfo(requireNotNull(location.data))
                }
                is Resource.Error -> {
                    _state.value =
                        _state.value.copy(error = "Can't retrieve weather info from selected city: $cityName")
                }
            }
        }
    }

    private fun loadWeatherInfo(location: Location) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            val weatherInfo =
                repository.getWeatherData(location.latitude, location.longitude)
            _state.value = when (weatherInfo) {
                is Resource.Success -> {
                    _state.value.copy(isLoading = false,
                        weatherInfo = weatherInfo.data,
                        currentLocation = Location(latitude = location.latitude,
                            longitude = location.longitude))
                }
                is Resource.Error -> {
                    _state.value.copy(isLoading = false, error = weatherInfo.message)
                }
            }
        }
    }

    private fun loadCityName(location: Location) {
        viewModelScope.launch {
            repository.getCityByCoordinates(location).let { result ->
                _state.value = when (result) {
                    is Resource.Success -> {
                        _state.value.copy(cityName = requireNotNull(result.data))
                    }
                    is Resource.Error -> {
                        Log.d("MYTAG", result.message ?: "Name loading error")
                        _state.value.copy(error = result.message ?: "Name loading error")
                    }
                }
            }
        }
    }

}
