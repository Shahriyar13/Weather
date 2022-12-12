package com.github.shahriyar13.data.datasource.weather

import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.CurrentWeatherEntity
import com.github.shahriyar13.domain.entity.DailyWeatherEntity
import com.github.shahriyar13.domain.entity.LocationEntity

interface WeatherLocalDataSource {
    suspend fun getLastCurrentWeather(): AppResult<CurrentWeatherEntity>
    suspend fun getLastDailyWeather(): AppResult<List<DailyWeatherEntity>>
    suspend fun saveLastCurrentWeather(lastWeather: CurrentWeatherEntity)
    suspend fun saveLastDailyWeather(lastWeather: List<DailyWeatherEntity>)
    suspend fun saveWeatherLocation(location: LocationEntity)
    suspend fun getWeatherLocation(): AppResult<LocationEntity>
}