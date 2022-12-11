package com.github.shahriyar13.data.datasource.weather

import com.github.shahriyar13.data.local.pref.PreferencesKeys
import com.github.shahriyar13.data.local.pref.WeatherPreferences
import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult

class WeatherLocalDataSourceImpl(
    private val weatherPreferences: WeatherPreferences
): WeatherLocalDataSource {

    override suspend fun getLastWeather(): AppResult<OneCallApiResponse?> =
        weatherPreferences.read(PreferencesKeys.currentWeatherKey)

    override suspend fun saveLastWeather(lastWeather: OneCallApiResponse) {
        weatherPreferences.save(PreferencesKeys.currentWeatherKey, lastWeather)
    }
}