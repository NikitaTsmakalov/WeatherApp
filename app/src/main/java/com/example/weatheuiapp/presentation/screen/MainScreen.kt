package com.example.weatheuiapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatheruiapp.R
import com.example.weatheuiapp.presentation.screen.components.CurrentWeather
import com.example.weatheuiapp.presentation.screen.components.Forecast
import com.example.weatheuiapp.presentation.screen.components.LoadingAndError
import com.example.weatheuiapp.presentation.viewmodel.WeatherViewModel

@Composable
fun MainScreen(viewModel: WeatherViewModel, navController: NavController) {
    LaunchedEffect(Unit) {
        viewModel.fetchWeather()
    }

    val weather = viewModel.currentWeather
    val forecast = viewModel.forecast
    val error = viewModel.error

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = viewModel.getBackgroundRes()),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(R.drawable.plus),
                    contentDescription = "Добавить город",
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.CenterVertically)
                        .clickable { navController.navigate("city_selection") }
                )
            }

            weather?.let {
                CurrentWeather(weather = it, modifier = Modifier.weight(1f))
            }

            forecast?.let {
                Forecast(forecast = it.items)
            }
        }

        LoadingAndError(
            error = error,
            isLoading = weather == null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}