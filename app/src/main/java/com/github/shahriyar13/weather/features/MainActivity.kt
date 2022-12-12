package com.github.shahriyar13.weather.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.shahriyar13.weather.features.daily.DailyWeatherScreen
import com.github.shahriyar13.weather.features.home.CurrentWeatherScreen
import com.github.shahriyar13.weather.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "CurrentWeather") {
        composable("CurrentWeather") { CurrentWeatherScreen() }
        composable("DailyWeather") { DailyWeatherScreen() }
    }
}