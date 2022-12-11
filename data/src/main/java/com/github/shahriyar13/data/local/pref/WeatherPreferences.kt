package com.github.shahriyar13.data.local.pref

import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult

interface WeatherPreferences {
    suspend fun save(key: String, value: OneCallApiResponse)
    fun read(key: String): AppResult<OneCallApiResponse?>
}