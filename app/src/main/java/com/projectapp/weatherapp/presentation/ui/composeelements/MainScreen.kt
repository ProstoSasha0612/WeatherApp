package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projectapp.weatherapp.data.api.CityName
import com.projectapp.weatherapp.domain.weather.WeatherData
import com.projectapp.weatherapp.domain.weather.WeatherInfo
import com.projectapp.weatherapp.domain.weather.WeatherType
import com.projectapp.weatherapp.presentation.view.mainscreen.MainViewModel
import com.projectapp.weatherapp.presentation.view.state.WeatherState
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

const val DEFAULT_PADDING = 16

@Composable
fun MainScreen(viewModel: MainViewModel, on7dayClick: () -> Unit) {
    val weatherState = viewModel.weatherState.collectAsState()
    val cityName = viewModel.cityName.collectAsState()
    BackgroundGradientSurface {
        when (weatherState.value) {
            is WeatherState.Success -> {
                val weatherData = (weatherState.value as WeatherState.Success).weatherInfo
                MainScreenSuccess(
                    weatherInfo = weatherData,
                    cityName = cityName.value,
                    on7dayClick = on7dayClick,
                )
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
fun MainScreenSuccess(weatherInfo: WeatherInfo, cityName: String, on7dayClick: () -> Unit) {
    Column() {
        CurrentCityBar(cityName) {
        }

        Spacer(modifier = Modifier.height(32.dp))

        CurrentTimeBar(
            requireNotNull(weatherInfo.currentWeatherData?.time),
            onClick = { on7dayClick() },
        )

        Spacer(modifier = Modifier.height(64.dp))


        CurrentWeatherCard(requireNotNull(weatherInfo.currentWeatherData))


        LazyRow(
            modifier = Modifier.padding(vertical = 16.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val list = requireNotNull(weatherInfo.weatherDataPerDay.get(0))
            items(list) { item: WeatherData ->
                HourForecastCard(weatherData = item)
            }
        }


    }
}


@Preview(showBackground = true, backgroundColor = 0xff121524, widthDp = 320)
@Composable
fun MainScreenPreview() {
    val weatherData = WeatherData(
        LocalDateTime.parse("2022-07-01T00:00", DateTimeFormatter.ISO_DATE_TIME),
        temperature = 18.0,
        pressure = 90.0,
        windSpeed = 15.0,
        humidity = 24,
        weatherType = WeatherType.fromWMO(1),
    )
    MainScreenSuccess(
        weatherInfo = WeatherInfo(
            weatherDataPerDay = mapOf(pair = Pair(0, List(24) { weatherData })),
            currentWeatherData = weatherData
        ),
        cityName = "Tbilsi",
        on7dayClick = {}
    )
}

