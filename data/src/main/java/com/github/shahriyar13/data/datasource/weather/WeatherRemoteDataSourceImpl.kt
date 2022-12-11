package com.github.shahriyar13.data.datasource.weather

import com.github.shahriyar13.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRemoteDataSourceImpl @Inject constructor(
    private val api: ApiService,
):WeatherRemoteDataSource{
    override suspend fun getWeather(): Result<List<Any>> {//TODO: entity
        return withContext(Dispatchers.IO) {
            val result = api.getOneCallForecast(
                latitude = 23.3,
                longitude = 23.3,
            )

            result.body().let {
                AppResult.success(it.mapToEntity())//TODO: add mapper and resolve data deps
            }

        }
    }
}