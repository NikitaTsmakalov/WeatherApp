package com.example.weatheuiapp.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import com.example.weatheuiapp.domain.model.ForecastDisplayItem
import kotlin.math.roundToInt

@Composable
fun Forecast(forecast: List<ForecastDisplayItem>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(radius = 5.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Black.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(6.dp)
        ) {
            LazyRow(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(forecast) { forecastItem ->
                    Column(
                        modifier = Modifier
                            .width(70.dp)
                            .padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = forecastItem.day.take(3),
                            fontSize = 14.sp,
                            color = Color.White
                        )
                        Text(
                            text = forecastItem.time,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Image(
                            painter = painterResource(forecastItem.icon),
                            contentDescription = "Погода",
                            modifier = Modifier
                                .size(46.dp)
                                .padding(top = 8.dp)
                        )
                        Text(
                            text = "${forecastItem.temp.roundToInt()}°",
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}