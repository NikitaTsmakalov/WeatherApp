package com.example.weatheuiapp.domain.usecase

import com.example.weatheuiapp.data.repository.WeatherRepository
import com.example.weatheuiapp.domain.model.Forecast
import com.example.weatheuiapp.domain.model.mapToForecastDisplayItems

class GetForecastUseCase(private val repository: WeatherRepository) {
    suspend fun execute(city: String): Forecast {
        val response = repository.getForecast(city)
        return Forecast(items = mapToForecastDisplayItems(response.list))
    }
}