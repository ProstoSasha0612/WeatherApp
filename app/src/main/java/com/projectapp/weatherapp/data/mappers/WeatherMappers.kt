package com.projectapp.weatherapp.data.mappers

import com.projectapp.weatherapp.data.api.WeatherDataDto
import com.projectapp.weatherapp.data.api.WeatherDto
import com.projectapp.weatherapp.domain.weather.WeatherData
import com.projectapp.weatherapp.domain.weather.WeatherInfo
import com.projectapp.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData,
)

//current day 0, tomorrow 1, and so on until 6
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return times.mapIndexed { index: Int, time: String ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val humidity = humidities[index]
        val pressure = pressures[index]

        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperature = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val currentTime = LocalDateTime.now()

    var currentWeatherData = weatherDataMap[0]?.find { weatherData: WeatherData ->
        val hour = when {
            currentTime.minute < 30 -> currentTime.hour
            //if 23:30 we need to get next day hour 00:00, and there are no data in weatherDataMap[0]
            //data is in weatherDataMap[1]
            currentTime.hour == 23 -> null
            else -> currentTime.hour + 1
        }
        currentTime.hour == hour
    }
    if (currentWeatherData == null) {
        currentWeatherData = weatherDataMap[1]?.find { it.time.hour == 0 }
    }

    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )

}