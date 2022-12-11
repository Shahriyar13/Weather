package com.github.shahriyar13.data.datasource.weather

import com.github.shahriyar13.data.local.pref.PreferencesKeys
import com.github.shahriyar13.data.local.pref.WeatherPreferences
import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.LocationEntity

class WeatherLocalDataSourceImpl(
    private val weatherPreferences: WeatherPreferences
): WeatherLocalDataSource {

    override suspend fun getLastWeather(): AppResult<OneCallApiResponse?> =
        weatherPreferences.readWeather(PreferencesKeys.lastWeatherKey)

    override suspend fun saveLastWeather(lastWeather: OneCallApiResponse) {
        weatherPreferences.saveWeather(PreferencesKeys.lastWeatherKey, lastWeather)
    }

    override suspend fun saveWeatherLocation(location: LocationEntity) {
        weatherPreferences.saveLocation(PreferencesKeys.lastLocationKey, location)
    }

    override suspend fun getWeatherLocation() =
        weatherPreferences.readLocation(PreferencesKeys.lastLocationKey)
}