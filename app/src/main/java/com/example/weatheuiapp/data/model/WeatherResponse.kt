package com.example.weatheuiapp.data.model

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind,
    val name: String
)

data class Main(
    val temp: Float,
    val humidity: Int,
    val temp_max: Float,
    val temp_min: Float
)

data class Weather(
    val description: String,
    val icon: String
)

data class Wind(
    val speed: Float
)

data class ForecastResponse(
    val list: List<ForecastItem>
)

data class ForecastItem(
    val dt: Long,
    val main: Main,
    val weather: List<Weather>,
    val dt_txt: String
)