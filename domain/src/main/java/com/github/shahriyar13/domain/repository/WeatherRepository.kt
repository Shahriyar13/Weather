package com.github.shahriyar13.domain.repository

import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.CurrentWeatherEntity
import com.github.shahriyar13.domain.entity.DailyWeatherEntity
import com.github.shahriyar13.domain.entity.LocationEntity

interface WeatherRepository {
    suspend fun setWeatherLocation(location: LocationEntity)
    suspend fun updateWeather()
    suspend fun getCurrentWeather(): AppResult<CurrentWeatherEntity>
    suspend fun getDailyWeather(): AppResult<List<DailyWeatherEntity>>
}