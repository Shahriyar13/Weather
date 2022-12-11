package com.github.shahriyar13.data.datasource.weather

import com.github.shahriyar13.data.remote.ApiService
import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRemoteDataSourceImpl @Inject constructor(
    private val api: ApiService,
):WeatherRemoteDataSource{
    override suspend fun getWeather(): AppResult<OneCallApiResponse> {//TODO: entity
        return withContext(Dispatchers.IO) {
            val result = api.getOneCallForecast(
                latitude = 23.3,
                longitude = 23.3,
            )

            result.body().let {
                AppResult.Success(it)
            }

            AppResult.Error(Exception())

        }
    }
}