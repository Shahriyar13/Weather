package com.github.shahriyar13.data.local.pref

import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.LocationEntity

interface WeatherPreferences {
    suspend fun saveWeather(key: String, value: OneCallApiResponse)
    fun readWeather(key: String): AppResult<OneCallApiResponse?>
    suspend fun saveLocation(key: String, value: LocationEntity)
    fun readLocation(key: String): LocationEntity
}