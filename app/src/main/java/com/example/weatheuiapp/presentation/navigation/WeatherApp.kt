package com.example.weatheuiapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatheuiapp.data.repository.WeatherRepositoryImpl
import com.example.weatheuiapp.domain.usecase.GetForecastUseCase
import com.example.weatheuiapp.domain.usecase.GetWeatherUseCase
import com.example.weatheuiapp.presentation.screen.CitySelectionScreen
import com.example.weatheuiapp.presentation.screen.MainScreen
import com.example.weatheuiapp.presentation.viewmodel.WeatherViewModel

@Composable
fun WeatherApp(viewModel: WeatherViewModel = viewModel(
    factory = WeatherViewModel.Factory(
        GetWeatherUseCase(WeatherRepositoryImpl()),
        GetForecastUseCase(WeatherRepositoryImpl())
    )
)) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main",
        modifier = Modifier. fillMaxSize()
    ) {
        composable("main") {
            MainScreen(viewModel, navController)
        }
        composable("city_selection") {
            CitySelectionScreen(
                navController = navController,
                onCitySelected = { city ->
                    viewModel.updateCity(city)
                    viewModel.fetchWeather()
                }
            )
        }
    }
}