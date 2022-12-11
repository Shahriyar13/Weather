package com.github.shahriyar13.data.datasource.weather

interface WeatherRemoteDataSource {
    suspend fun getWeather(): Result<Any>//TODO: entity
}