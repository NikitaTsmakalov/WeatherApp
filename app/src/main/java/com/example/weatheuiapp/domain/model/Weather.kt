package com.example.weatheuiapp.domain.model

data class Weather(
    val cityName: String,
    val temperature: Float,
    val humidity: Int,
    val windSpeed: Float,
    val description: String,
    val icon: String,
    val maxTemp: Float,
    val minTemp: Float
)