package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projectapp.weatherapp.composeui.BackgroundGradientSurface
import com.projectapp.weatherapp.composeui.CurrentCityBar
import com.projectapp.weatherapp.composeui.CurrentWeatherCard

const val DEFAULT_PADDING = 16

@Composable
fun MainScreen() {
    BackgroundGradientSurface {
        Column() {
            CurrentCityBar {

            }

            Spacer(modifier = Modifier.height(32.dp))

            CurrentCityBar {

            }

            Spacer(modifier = Modifier.height(64.dp))

            CurrentWeatherCard()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xff121524, widthDp = 320)
@Composable
fun MainScreenPreview() {
    MainScreen()
}

