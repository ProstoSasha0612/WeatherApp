package com.projectapp.weatherapp.domain.weather

import androidx.annotation.DrawableRes

sealed class WeatherType(val id: Int, val description: String, iconUrl: String) {
    object Thunderstorm200 : WeatherType(
        200,
        "thunderstorm with light rain",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    object Thunderstorm201 : WeatherType(
        201,
        "thunderstorm with rain",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    object Thunderstorm202 : WeatherType(
        202,
        "thunderstorm with heavy rain",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    object Thunderstorm210 : WeatherType(
        210,
        "light thunderstorm",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    object Thunderstorm211 : WeatherType(
        211,
        "thunderstorm",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    object Thunderstorm212 : WeatherType(
        212,
        "heavy thunderstorm",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    object Thunderstorm221 : WeatherType(
        221,
        "ragged thunderstorm",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    object Thunderstorm230 : WeatherType(
        230,
        "thunderstorm with light drizzle",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    object Thunderstorm231 : WeatherType(
        231,
        "thunderstorm with drizzle",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    object Thunderstorm232 : WeatherType(
        232,
        "thunderstorm with heavy drizzle",
        "http://openweathermap.org/img/wn/11d@4x.png",
    )
    /*Drizzle*/
    object Drizzle300 : WeatherType(
        300,
        "light intensity drizzle",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Drizzle301 : WeatherType(
        301,
        "drizzle",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Drizzle302 : WeatherType(
        302,
        "heavy intensity drizzle",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Drizzle310 : WeatherType(
        310,
        "light intensity drizzle rain",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Drizzle311 : WeatherType(
        311,
        "drizzle rain",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Drizzle312 : WeatherType(
        312,
        "heavy intensity drizzle rain",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Drizzle313 : WeatherType(
        313,
        "shower rain and drizzle",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Drizzle314 : WeatherType(
        314,
        "heavy shower rain and drizzle",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Drizzle321 : WeatherType(
        321,
        "shower drizzle",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    /*Rain*/
    object Rain500 : WeatherType(
        500,
        "light rain",
        "http://openweathermap.org/img/wn/10d@4x.png",
    )
    object Rain501 : WeatherType(
        501,
        "moderate rain",
        "http://openweathermap.org/img/wn/10d@4x.png",
    )
    object Rain502 : WeatherType(
        502,
        "heavy intensity rain",
        "http://openweathermap.org/img/wn/10d@4x.png",
    )
    object Rain503 : WeatherType(
        503,
        "very heavy rain",
        "http://openweathermap.org/img/wn/10d@4x.png",
    )
    object Rain504 : WeatherType(
        504,
        "extreme rain",
        "http://openweathermap.org/img/wn/10d@4x.png",
    )
    object Rain511 : WeatherType(
        511,
        "freezing rain",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Rain520 : WeatherType(
        520,
        "light intensity shower rain",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Rain521 : WeatherType(
        521,
        "shower rain",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Rain522 : WeatherType(
        522,
        "light intensity shower rain",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Rain523 : WeatherType(
        523,
        "heavy intensity shower rain",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    object Rain531 : WeatherType(
        531,
        "ragged shower rain",
        "http://openweathermap.org/img/wn/09d@4x.png",
    )
    /*Snow*/
    object Snow600 : WeatherType(
        600,
        "light snow",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Snow601 : WeatherType(
        601,
        "Snow",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Snow602 : WeatherType(
        602,
        "Heavy snow",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Snow611 : WeatherType(
        611,
        "Sleet",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Snow612 : WeatherType(
        612,
        "Light shower sleet",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Snow613 : WeatherType(
        613,
        "Shower sleet",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )

    object Snow615 : WeatherType(
        615,
        "Light rain and snow",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Snow616 : WeatherType(
        616,
        "Rain and snow",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Snow620 : WeatherType(
        620,
        "Light shower snow",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Snow621 : WeatherType(
        621,
        "Shower snow",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    object Snow622 : WeatherType(
        622,
        "Heavy shower snow",
        "http://openweathermap.org/img/wn/13d@4x.png",
    )
    /*Atmosphere*/
    object Mist701 : WeatherType(
        701,
        "mist",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    object Smoke711 : WeatherType(
        711,
        "Smoke",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    object Haze721 : WeatherType(
        721,
        "Haze",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    object Dust731 : WeatherType(
        731,
        "sand/ dust whirls",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    object Fog741 : WeatherType(
        741,
        "fog",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    object Sand751 : WeatherType(
        751,
        "sand",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    object Dust761 : WeatherType(
        761,
        "dust",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    object Ash762 : WeatherType(
        762,
        "volcanic ash",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    object Squall771 : WeatherType(
        771,
        "squalls",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    object Tornado781 : WeatherType(
        781,
        "tornado",
        "http://openweathermap.org/img/wn/50d@4x.png",
    )
    /*Clear*/
    object Clear800 : WeatherType(
        800,
        "clear sky",
        "http://openweathermap.org/img/wn/01d@4x.png",
    )
    /*Clouds*/
    object Clouds801 : WeatherType(
        801,
        "few clouds: 11-25%",
        "http://openweathermap.org/img/wn/02d@4x.png",
    )
    object Clouds802 : WeatherType(
        802,
        "scattered clouds: 25-50%",
        "http://openweathermap.org/img/wn/03d@4x.png",
    )
    object Clouds803 : WeatherType(
        803,
        "broken clouds: 51-84%",
        "http://openweathermap.org/img/wn/04d@4x.png",
    )
    object Clouds804 : WeatherType(
        804,
        "overcast clouds: 85-100%",
        "http://openweathermap.org/img/wn/04d@4x.png",
    )


}