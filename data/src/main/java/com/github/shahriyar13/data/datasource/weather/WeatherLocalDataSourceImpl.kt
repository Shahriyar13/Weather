package com.github.shahriyar13.data.datasource.weather

import com.github.shahriyar13.data.local.pref.PreferencesKeys
import com.github.shahriyar13.data.local.pref.WeatherPreferences
import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.CurrentWeatherEntity
import com.github.shahriyar13.domain.entity.DailyWeatherEntity
import com.github.shahriyar13.domain.entity.LocationEntity

class WeatherLocalDataSourceImpl(
    private val weatherPreferences: WeatherPreferences
): WeatherLocalDataSource {

    override suspend fun getLastCurrentWeather(): AppResult<CurrentWeatherEntity> =
        weatherPreferences.read(PreferencesKeys.lastCurrentWeatherKey)

    override suspend fun getLastDailyWeather(): AppResult<List<DailyWeatherEntity>> =
        weatherPreferences.read(PreferencesKeys.lastDailyWeatherKey)

    override suspend fun saveLastCurrentWeather(lastWeather: CurrentWeatherEntity) {
        weatherPreferences.save(PreferencesKeys.lastCurrentWeatherKey, lastWeather)
    }

    override suspend fun saveLastDailyWeather(lastWeather: List<DailyWeatherEntity>) {
        weatherPreferences.save(PreferencesKeys.lastCurrentWeatherKey, lastWeather)
    }

    override suspend fun saveWeatherLocation(location: LocationEntity) {
        weatherPreferences.save(PreferencesKeys.lastLocationKey, location)
    }

    override suspend fun getWeatherLocation() =
        weatherPreferences.read<LocationEntity>(PreferencesKeys.lastLocationKey)
}