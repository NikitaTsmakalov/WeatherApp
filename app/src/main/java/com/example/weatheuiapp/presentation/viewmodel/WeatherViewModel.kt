package com.example.weatheuiapp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.weatheruiapp.R
import com.example.weatheuiapp.domain.model.Forecast
import com.example.weatheuiapp.domain.model.Weather
import com.example.weatheuiapp.domain.usecase.GetForecastUseCase
import com.example.weatheuiapp.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getForecastUseCase: GetForecastUseCase
) : ViewModel() {
    var currentWeather by mutableStateOf<Weather?>(null)
        private set
    var forecast by mutableStateOf<Forecast?>(null)
        private set
    var error by mutableStateOf<String?>(null)
        private set
    var selectedCity by mutableStateOf("Moscow")
        private set

    fun fetchWeather(city: String = selectedCity) {
        viewModelScope.launch {
            try {
                currentWeather = getWeatherUseCase.execute(city)
                forecast = getForecastUseCase.execute(city)
                selectedCity = city
                error = null

                Log.d("WeatherViewModel", "Fetched weather for city: $city")
                Log.d("WeatherViewModel", "Current weather: $currentWeather")
                Log.d("WeatherViewModel", "Forecast size: ${forecast?.items?.size}")
            } catch (e: Exception) {
                error = e.message
                currentWeather = null
                forecast = null
                Log.e("WeatherViewModel", "Error fetching weather: ${e.message}")
            }
        }
    }

    fun updateCity(city: String) {
        selectedCity = city
        fetchWeather(city)
    }

    fun getBackgroundRes(): Int {
        val weatherDescription = currentWeather?.description?.lowercase()
        val weatherIcon = currentWeather?.icon
        val isNight = weatherIcon?.endsWith("n") == true

        return when {
            isNight -> R.drawable.night_bg
            weatherDescription == "clear" -> R.drawable.sunny_bg
            weatherDescription == "clouds" -> R.drawable.cloudy_bg
            weatherDescription == "broken clouds" -> R.drawable.cloudy_bg
            weatherDescription == "rain" -> R.drawable.rainy_bg
            weatherDescription == "overcast clouds" -> R.drawable.rainy_bg
            weatherDescription == "light rain" -> R.drawable.rainy_bg
            weatherDescription == "snow" -> R.drawable.snow_bg
            weatherDescription == "haze" -> R.drawable.haze_bg
            else -> R.drawable.sunny_bg
        }
    }

    class Factory(
        private val getWeatherUseCase: GetWeatherUseCase,
        private val getForecastUseCase: GetForecastUseCase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
                return WeatherViewModel(getWeatherUseCase, getForecastUseCase) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}