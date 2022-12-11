package com.github.shahriyar13.data.repository

import android.text.format.DateUtils
import com.github.shahriyar13.data.datasource.weather.WeatherLocalDataSource
import com.github.shahriyar13.data.datasource.weather.WeatherRemoteDataSource
import com.github.shahriyar13.data.remote.model.mapper.mapToEntity
import com.github.shahriyar13.domain.data
import com.github.shahriyar13.domain.entity.CurrentWeatherEntity
import com.github.shahriyar13.domain.entity.DailyWeatherEntity
import com.github.shahriyar13.domain.entity.LocationEntity
import com.github.shahriyar13.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource
): WeatherRepository {

    override suspend fun setWeatherLocation(location: LocationEntity) {
        weatherLocalDataSource.saveWeatherLocation(location)
    }

    override suspend fun updateWeather() {
        val weatherResult = weatherRemoteDataSource.getWeather(weatherLocalDataSource.getWeatherLocation())
        weatherResult.data?.let { data ->
            weatherLocalDataSource.saveLastWeather(data)
        }
    }

    override suspend fun getCurrentWeather(): CurrentWeatherEntity {
        validateCachedWeather()
        return weatherLocalDataSource.getLastWeather().data?.current!!.mapToEntity()
    }

    override suspend fun getDailyWeather(): List<DailyWeatherEntity> {
        validateCachedWeather()
        return weatherLocalDataSource.getLastWeather().data?.daily!!.map { it.mapToEntity() }
    }

    private suspend fun validateCachedWeather() {
        if (isCachedWeatherValid().not()) {
            updateWeather()
        }
    }

    private suspend fun isCachedWeatherValid(): Boolean {
        val cachedCurrentWeather = weatherLocalDataSource.getLastWeather()
        cachedCurrentWeather.data?.let {
            return DateUtils.isToday(it.current.dt)
        }
        return false
    }
}