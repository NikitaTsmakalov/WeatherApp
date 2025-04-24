package com.example.weatheuiapp.data.api

import com.example.weatheuiapp.data.model.ForecastResponse
import com.example.weatheuiapp.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse

    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): ForecastResponse

    @GET("geo/1.0/direct")
    suspend fun getCityCoordinates(
        @Query("q") city: String,
        @Query("limit") limit: Int = 5,
        @Query("appid") apiKey: String
    ): List<CityResponse>
}

data class CityResponse(
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String,
    val local_names: Map<String, String>?
)