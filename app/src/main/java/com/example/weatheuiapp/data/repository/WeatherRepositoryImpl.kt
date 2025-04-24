package com.example.weatheuiapp.data.repository


import com.example.weatheuiapp.data.api.RetrofitClient
import com.example.weatheuiapp.data.model.ForecastResponse
import com.example.weatheuiapp.data.model.WeatherResponse

class WeatherRepositoryImpl : WeatherRepository {
    override suspend fun getCurrentWeather(city: String): WeatherResponse {
        return RetrofitClient.weatherApi.getCurrentWeather(city, RetrofitClient.API_KEY)
    }

    override suspend fun getForecast(city: String): ForecastResponse {
        return RetrofitClient.weatherApi.getForecast(city, RetrofitClient.API_KEY)
    }
}