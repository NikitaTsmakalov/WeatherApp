package com.example.weatheuiapp.domain.usecase


import com.example.weatheuiapp.data.model.WeatherResponse
import com.example.weatheuiapp.data.repository.WeatherRepository
import com.example.weatheuiapp.domain.model.Weather

class GetWeatherUseCase(private val repository: WeatherRepository) {
    suspend fun execute(city: String): Weather {
        val response = repository.getCurrentWeather(city)
        return response.toDomain()
    }

    private fun WeatherResponse.toDomain(): Weather {
        return Weather(
            cityName = name,
            temperature = main.temp,
            humidity = main.humidity,
            windSpeed = wind.speed,
            description = weather.first().description,
            icon = weather.first().icon,
            maxTemp = main.temp_max,
            minTemp = main.temp_min
        )
    }
}