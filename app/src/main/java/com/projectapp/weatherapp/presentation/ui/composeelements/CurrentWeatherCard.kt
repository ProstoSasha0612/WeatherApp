package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectapp.weatherapp.domain.weather.WeatherData
import com.projectapp.weatherapp.domain.weather.WeatherType
import com.projectapp.weatherapp.presentation.ui.theme.LightDarkCardColor
import com.projectapp.weatherapp.presentation.ui.theme.GrayDefaultColor
import com.projectapp.wetherapp.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun CurrentWeatherCard(
    weatherData: WeatherData,
    backGroundColor: Color = LightDarkCardColor,
    modifier: Modifier = Modifier,
) {
    Card(
        backgroundColor = backGroundColor,
        modifier = modifier
            .padding(DEFAULT_PADDING.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = weatherData.weatherType.iconRes),
                    contentDescription = "weather type icon",
                    modifier = modifier.size(106.dp),
                    tint = Color.Unspecified,
                )
                Text(
                    text = "${weatherData.temperature}°",
                    color = GrayDefaultColor,
                    fontSize = 80.sp
                )
            }
            Spacer(modifier = modifier.height(16.dp))
            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                Text(
                    text = weatherData.weatherType.weatherDesc,
                    color = GrayDefaultColor,
                    fontSize = 32.sp,
                )
            }
            Spacer(modifier = modifier.height(32.dp))
            Row(modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                WeatherParamCard(parameterIconRes = R.drawable.ic_wind_parameter,
                    parameterName = "Wind",
                    value = "${weatherData.windSpeed} km/h"
                )
                WeatherParamCard(parameterIconRes = R.drawable.ic_humidity_parameter,
                    parameterName = "Humidity",
                    value = "${weatherData.humidity}%"
                )
                WeatherParamCard(parameterIconRes = R.drawable.ic_pressure_param,
                    parameterName = "Pressure",
                    value = "${weatherData.pressure} hpa"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentWeatherCardPreview() {
    CurrentWeatherCard(
        WeatherData(
            LocalDateTime.parse("2022-07-01T00:00", DateTimeFormatter.ISO_DATE_TIME),
            temperature = 18.0,
            pressure = 90.0,
            windSpeed = 15.0,
            humidity = 24,
            weatherType = WeatherType.fromWMO(1),
        )
    )
}