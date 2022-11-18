package com.projectapp.weatherapp.presentation.ui.composeelements.weekforecast

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projectapp.weatherapp.domain.weather.WeatherData
import com.projectapp.weatherapp.domain.weather.WeatherInfo
import com.projectapp.weatherapp.domain.weather.WeatherType
import com.projectapp.weatherapp.presentation.ui.composeelements.*
import com.projectapp.weatherapp.presentation.ui.theme.GrayDefaultColor
import com.projectapp.weatherapp.presentation.view.mainscreen.MainViewModel
import com.projectapp.weatherapp.presentation.view.state.WeatherState
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun WeekForecastScreen(viewModel: MainViewModel) {
    val weatherState = viewModel.weatherState.collectAsState()
    BackgroundGradientSurface {
        when (weatherState.value) {
            is WeatherState.Success -> {
                val weatherData = (weatherState.value as WeatherState.Success).weatherInfo
                MainScreenSuccess(weatherInfo = weatherData,/*TODO*/{})
            }
            is WeatherState.Loading -> {
                LoadingIndicator()
            }
            is WeatherState.Error -> {
                val message = (weatherState.value as WeatherState.Error).message
                ErrorIndicator(message)
            }
        }
    }
}

@Composable
fun WeekForecastScreenSuccess(weatherInfo: WeatherInfo) {
    Column(Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(text = "<- Back", color = GrayDefaultColor)
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Next 7 days", color = GrayDefaultColor)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            requireNotNull(weatherInfo.weatherDataPerDay).forEach { dayForecast ->
                val weatherDataAt12Am = dayForecast.value.get(11)
                item { DayForecastCard(weatherData = weatherDataAt12Am) }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xff02030a)
@Composable
fun WeekForecastScreenPreview() {
    val weatherData = WeatherData(
        LocalDateTime.parse("2022-07-01T00:00", DateTimeFormatter.ISO_DATE_TIME),
        temperature = 18.0,
        pressure = 90.0,
        windSpeed = 15.0,
        humidity = 24,
        weatherType = WeatherType.fromWMO(1),
    )
    val weatherInfo = WeatherInfo(
        weatherDataPerDay = mapOf(Pair(0, List(24) { weatherData }),
            Pair(0, List(24) { weatherData }),
            Pair(1, List(24) { weatherData }),
            Pair(2, List(24) { weatherData }),
            Pair(3, List(24) { weatherData }),
            Pair(4, List(24) { weatherData }),
            Pair(5, List(24) { weatherData })
        ),
        currentWeatherData = weatherData
    )
    WeekForecastScreenSuccess(weatherInfo)
}