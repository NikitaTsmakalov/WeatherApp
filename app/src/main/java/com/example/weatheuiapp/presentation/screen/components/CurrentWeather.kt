package com.example.weatheuiapp.presentation.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatheruiapp.R
import com.example.weatheuiapp.domain.model.Weather


@Composable
fun CurrentWeather(weather: Weather, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = transliterateCityName(weather.cityName),
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = translateWeatherDescription(weather.description),
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.wind),
                    contentDescription = "Ветер",
                    tint = Color.White,
                    modifier = Modifier
                        .size(64.dp)
                        .offset(y = 36.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "${weather.windSpeed.toInt()} м/с",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Ветер",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

            Text(
                text = "${weather.temperature.toInt()}°",
                fontSize = 75.sp,
                color = Color.White,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.humidity),
                    contentDescription = "Влажность",
                    tint = Color.White,
                    modifier = Modifier
                        .size(64.dp)
                        .offset(y = 36.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "${weather.humidity}%",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Влажность",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrow_up),
                    contentDescription = "Макс",
                    tint = Color.White,
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${weather.maxTemp.toInt()}°",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrow_down),
                    contentDescription = "Мин",
                    tint = Color.White,
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${weather.minTemp.toInt()}°",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}

fun translateWeatherDescription(description: String): String {
    return when (description.lowercase()) {
        "clear" -> "Ясно"
        "clouds" -> "Облачно"
        "rain" -> "Дождь"
        "light rain" -> "Лёгкий дождь"
        "snow" -> "Снег"
        "thunderstorm" -> "Гроза"
        "wind" -> "Ветрено"
        "broken clouds" -> "Переменная облачность"
        "scattered clouds" -> "Рассеянные облака"
        "few clouds" -> "Малооблачно"
        "overcast clouds" -> "Пасмурно"
        "clear sky" -> "Чистое небо"
        "mist" -> "туман"
        else -> description
    }
}

fun transliterateCityName(city: String): String {
    val transliterationMap = mapOf(
        "Moscow" to "Москва",
        "Saint Petersburg" to "Санкт-Петербург",
        "Kyiv" to "Киев",
        "Minsk" to "Минск",
        "London" to "Лондон",
        "Paris" to "Париж",
        "Berlin" to "Берлин",
        "Taganrog" to "Таганрог",
        "Rostov-on-Don" to "Ростов-на-Дону",
        "Ufa" to "Уфа"
    )
    return transliterationMap[city] ?: city
}