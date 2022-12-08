package com.projectapp.weatherapp.presentation.view.event

sealed class MainEvent {
    class WeekForecastNavigate(val onNavigateToWeekForecast: () -> Unit) : MainEvent()
    object LoadCurrentLocationWeather : MainEvent()
    class CityChanged(val newCity: String) : MainEvent()
}
