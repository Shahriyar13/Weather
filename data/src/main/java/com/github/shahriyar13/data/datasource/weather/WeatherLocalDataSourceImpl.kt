package com.github.shahriyar13.data.datasource.weather

import com.github.shahriyar13.data.local.pref.PreferencesKeys
import com.github.shahriyar13.data.local.pref.WeatherPreferences
import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.CurrentWeatherEntity
import com.github.shahriyar13.domain.entity.DailyWeatherEntity
import com.github.shahriyar13.domain.entity.LocationEntity
import javax.inject.Inject

class WeatherLocalDataSourceImpl @Inject constructor(
    private val weatherPreferences: WeatherPreferences
): WeatherLocalDataSource {

    override suspend fun getLastCurrentWeather(): AppResult<CurrentWeatherEntity> =
        weatherPreferences.read(PreferencesKeys.lastCurrentWeatherKey, CurrentWeatherEntity::class.java)

    override suspend fun getLastDailyWeather(): AppResult<List<DailyWeatherEntity>> =
        weatherPreferences.readList(PreferencesKeys.lastDailyWeatherKey, DailyWeatherEntity::class.java)

    override suspend fun saveLastCurrentWeather(lastWeather: CurrentWeatherEntity) {
        weatherPreferences.save(PreferencesKeys.lastCurrentWeatherKey, lastWeather)
    }

    override suspend fun saveLastDailyWeather(lastWeather: List<DailyWeatherEntity>) {
        weatherPreferences.saveList(PreferencesKeys.lastDailyWeatherKey, lastWeather)
    }

    override suspend fun saveWeatherLocation(location: LocationEntity) {
        weatherPreferences.save(PreferencesKeys.lastLocationKey, location)
    }

    override suspend fun getWeatherLocation(): AppResult<LocationEntity> =
        weatherPreferences.read(PreferencesKeys.lastLocationKey, LocationEntity::class.java)
}