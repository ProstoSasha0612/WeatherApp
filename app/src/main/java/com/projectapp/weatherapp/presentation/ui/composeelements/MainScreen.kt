package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projectapp.weatherapp.domain.weather.WeatherInfo
import com.projectapp.weatherapp.presentation.view.mainscreen.MainScreenViewModel
import com.projectapp.weatherapp.presentation.view.state.WeatherState

const val DEFAULT_PADDING = 16

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    val weatherState = viewModel.weatherState.collectAsState()
    BackgroundGradientSurface {
        when (weatherState.value) {
            is WeatherState.Success -> {
                val weatherData = (weatherState.value as WeatherState.Success).weatherInfo
                MainScreenSuccess(weatherInfo = weatherData)
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
fun MainScreenSuccess(weatherInfo: WeatherInfo) {
    Column() {
        CurrentCityBar {

        }

        Spacer(modifier = Modifier.height(32.dp))

        CurrentCityBar {

        }

        Spacer(modifier = Modifier.height(64.dp))


        CurrentWeatherCard(requireNotNull(weatherInfo.currentWeatherData))

    }
}


@Preview(showBackground = true, backgroundColor = 0xff121524, widthDp = 320)
@Composable
fun MainScreenPreview() {
//    MainScreen(
//    )
}

