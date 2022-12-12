package com.github.shahriyar13.data.local.pref

import com.github.shahriyar13.domain.AppResult

interface WeatherPreferences {
    suspend fun <T> save(key: String, value: T)
    suspend fun <T> read(key: String): AppResult<T>
}