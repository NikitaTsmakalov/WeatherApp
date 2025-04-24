package com.example.weatheuiapp.data.repository



import com.example.weatheuiapp.data.model.ForecastResponse
import com.example.weatheuiapp.data.model.WeatherResponse

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): WeatherResponse
    suspend fun getForecast(city: String): ForecastResponse
}