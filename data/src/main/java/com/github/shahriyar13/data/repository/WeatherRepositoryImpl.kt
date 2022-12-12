package com.github.shahriyar13.data.repository

import android.text.format.DateUtils
import com.github.shahriyar13.data.datasource.weather.WeatherLocalDataSource
import com.github.shahriyar13.data.datasource.weather.WeatherRemoteDataSource
import com.github.shahriyar13.data.remote.model.mapper.mapToEntity
import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.data
import com.github.shahriyar13.domain.entity.CurrentWeatherEntity
import com.github.shahriyar13.domain.entity.DailyWeatherEntity
import com.github.shahriyar13.domain.entity.LocationEntity
import com.github.shahriyar13.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource
): WeatherRepository {

    override suspend fun setWeatherLocation(location: LocationEntity) {
        weatherLocalDataSource.saveWeatherLocation(location)
    }

    override suspend fun updateWeather() {
        val locationResult = weatherLocalDataSource.getWeatherLocation()
        locationResult.data?.let { location ->
            val weatherResult = weatherRemoteDataSource.getWeather(location)
            weatherResult.data?.let { data ->
                weatherLocalDataSource.saveLastCurrentWeather(data.current.mapToEntity())
                weatherLocalDataSource.saveLastDailyWeather(data.daily.map { daily -> daily.mapToEntity() })
            }
        }
    }

    override suspend fun getCurrentWeather(): AppResult<CurrentWeatherEntity> {
        validateCachedWeather()
        return weatherLocalDataSource.getLastCurrentWeather()
    }

    override suspend fun getDailyWeather(): AppResult<List<DailyWeatherEntity>> {
        validateCachedWeather()
        return weatherLocalDataSource.getLastDailyWeather()
    }

    private suspend fun validateCachedWeather() {
        if (isCachedWeatherValid().not()) {
            updateWeather()
        }
    }

    private suspend fun isCachedWeatherValid(): Boolean {
        val cachedCurrentWeather = weatherLocalDataSource.getLastCurrentWeather()
        cachedCurrentWeather.data?.let {
            return DateUtils.isToday(it.date.time)
        }
        return false
    }
}