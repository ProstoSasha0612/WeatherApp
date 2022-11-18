package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectapp.weatherapp.domain.weather.WeatherData
import com.projectapp.weatherapp.domain.weather.WeatherInfo
import com.projectapp.weatherapp.domain.weather.WeatherType
import com.projectapp.weatherapp.presentation.ui.theme.GrayDefaultColor
import com.projectapp.weatherapp.presentation.ui.theme.HourForecastGradColor
import com.projectapp.weatherapp.presentation.ui.theme.LightDarkCardColor
import com.projectapp.weatherapp.presentation.ui.theme.StrongGrayColor
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun HourForecastCard(
    weatherData: WeatherData,
    backGroundColor: Color = HourForecastGradColor,
    modifier: Modifier = Modifier,
) {
    Card(
        backgroundColor = backGroundColor,
        shape = RoundedCornerShape(45),
    ) {
        Column(
            Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = weatherData.time.format(DateTimeFormatter.ofPattern("HH:mm")),
                fontSize = 12.sp,
                color = StrongGrayColor,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = weatherData.weatherType.iconRes),
                contentDescription = "weather type icon",
                Modifier.size(32.dp),
                tint = Color.Unspecified
            )
            Text(
                text = "${weatherData.temperature}°",
                color = GrayDefaultColor,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun HourForecastCardPreview() {
    HourForecastCard(weatherData = WeatherData(
        LocalDateTime.parse("2022-07-01T00:00", DateTimeFormatter.ISO_DATE_TIME),
        temperature = 18.0,
        pressure = 90.0,
        windSpeed = 15.0,
        humidity = 24,
        weatherType = WeatherType.fromWMO(1),
    ))
}