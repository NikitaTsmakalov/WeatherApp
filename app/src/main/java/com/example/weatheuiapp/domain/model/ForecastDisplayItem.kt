package com.example.weatheuiapp.domain.model

import android.util.Log
import com.example.weatheruiapp.R
import com.example.weatheuiapp.data.model.ForecastItem
import java.text.SimpleDateFormat
import java.util.*

data class ForecastDisplayItem(
    val day: String,
    val time: String,
    val icon: Int,
    val temp: Float
)

fun mapToForecastDisplayItems(forecastItems: List<ForecastItem>): List<ForecastDisplayItem> {
    val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val dayFormat = SimpleDateFormat("EEEE", Locale("ru"))
    val calendar = Calendar.getInstance()

    Log.d("ForecastDebug", "Total forecast items received: ${forecastItems.size}")

    val availableForecast = forecastItems.take(12)
    val result = mutableListOf<ForecastDisplayItem>()

    availableForecast.forEachIndexed { index, item ->
        calendar.timeInMillis = item.dt * 1000L
        val dayRaw = dayFormat.format(calendar.time)
        val day = dayRaw.replaceFirstChar { it.uppercaseChar() }
        val time = dateFormat.format(calendar.time)
        val icon = when (item.weather.first().description.lowercase()) {
            "clear" -> R.drawable.sunny
            "clouds" -> R.drawable.cloudy
            "rain" -> R.drawable.rainy
            "snow" -> R.drawable.snowy
            "thunderstorm" -> R.drawable.storm
            "wind" -> R.drawable.windy
            "broken clouds", "scattered clouds" -> R.drawable.cloudy_sunny
            else -> R.drawable.cloudy
        }
        result.add(
            ForecastDisplayItem(
                day = day,
                time = time,
                icon = icon,
                temp = item.main.temp
            )
        )
        Log.d("ForecastDebug", "Item $index: $day $time, Temp: ${item.main.temp}, Weather: ${item.weather.first().description}")
    }

    while (result.size < 12) {
        val lastItem = result.lastOrNull()
        calendar.timeInMillis += 3 * 60 * 60 * 1000
        val dayRaw = dayFormat.format(calendar.time)
        val day = dayRaw.replaceFirstChar { it.uppercaseChar() }
        val time = dateFormat.format(calendar.time)
        result.add(
            ForecastDisplayItem(
                day = day,
                time = time,
                icon = lastItem?.icon ?: R.drawable.cloudy,
                temp = lastItem?.temp ?: 0f
            )
        )
        Log.d("ForecastDebug", "Added filler: $day $time, Temp: ${lastItem?.temp ?: 0f}")
    }

    return result
}