package com.github.shahriyar13.data.datasource.weather

import com.github.shahriyar13.data.remote.ApiService
import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.LocationEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRemoteDataSourceImpl @Inject constructor(
    val api: ApiService,
):WeatherRemoteDataSource{
    override suspend fun getWeather(location: LocationEntity): AppResult<OneCallApiResponse> {
        try {
            val result = api.getOneCallForecast(
                latitude = location.lat,
                longitude = location.lng,
            )

            result.body()?.let {
                return AppResult.Success(it)
            }

            return AppResult.Error(Exception())

        } catch (e: Exception) {
            return AppResult.Error(e)
        }
    }
}