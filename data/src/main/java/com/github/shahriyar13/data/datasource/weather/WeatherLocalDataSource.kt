package com.github.shahriyar13.data.datasource.weather

import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult

interface WeatherLocalDataSource {
    suspend fun getLastWeather(): AppResult<OneCallApiResponse?>
    suspend fun saveLastWeather(lastWeather: OneCallApiResponse)
}