package com.github.shahriyar13.domain.repository

import com.github.shahriyar13.domain.entity.CurrentWeatherEntity
import com.github.shahriyar13.domain.entity.DailyWeatherEntity

interface WeatherRepository {
    suspend fun updateWeather()
    suspend fun getCurrentWeather(): CurrentWeatherEntity
    suspend fun getDailyWeather(): List<DailyWeatherEntity>
}