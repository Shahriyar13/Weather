package com.github.shahriyar13.data.datasource.weather
import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.LocationEntity

interface WeatherRemoteDataSource {
    suspend fun getWeather(location: LocationEntity): AppResult<OneCallApiResponse>
}