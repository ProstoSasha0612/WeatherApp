package com.projectapp.weatherapp.presentation.ui.composeelements.weekforecast

import androidx.compose.foundation.layout.*
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
import com.projectapp.weatherapp.presentation.ui.theme.GrayDefaultColor
import com.projectapp.weatherapp.presentation.ui.theme.StrongGrayColor
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun DayForecastCard(weatherData: WeatherData) {
    val dayOfWeek =
        weatherData.time.format(DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ENGLISH))
    val date =
        weatherData.time.format(DateTimeFormatter.ofPattern("dd MMMM").withLocale(Locale.ENGLISH))

    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column() {
            Text(text = dayOfWeek, color = GrayDefaultColor, fontSize = 16.sp)
            Text(text = date, color = StrongGrayColor, fontSize = 12.sp)
        }
        Icon(
            imageVector = ImageVector.vectorResource(id = weatherData.weatherType.iconRes),
            contentDescription = "weather type icon",
            Modifier.size(32.dp),
            tint = Color.Unspecified
        )
        Row {
            Text(text = "${weatherData.temperature}°", color = StrongGrayColor, fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DayForecastCardPreview() {
    DayForecastCard(
        weatherData = WeatherData(
            LocalDateTime.parse("2022-07-01T00:00", DateTimeFormatter.ISO_DATE_TIME),
            temperature = 18.0,
            pressure = 90.0,
            windSpeed = 15.0,
            humidity = 24,
            weatherType = WeatherType.fromWMO(1),
        )
    )
}