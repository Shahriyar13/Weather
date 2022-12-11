package com.github.shahriyar13.data.datasource.weather
import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult

interface WeatherRemoteDataSource {
    suspend fun getWeather(): AppResult<OneCallApiResponse>
}