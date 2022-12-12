package com.github.shahriyar13.data.di

import com.github.shahriyar13.data.datasource.weather.WeatherLocalDataSource
import com.github.shahriyar13.data.datasource.weather.WeatherLocalDataSourceImpl
import com.github.shahriyar13.data.datasource.weather.WeatherRemoteDataSource
import com.github.shahriyar13.data.datasource.weather.WeatherRemoteDataSourceImpl
import com.github.shahriyar13.data.local.pref.WeatherPreferences
import com.github.shahriyar13.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {

    @Provides
    fun provideWeatherLocalDataSource(
        weatherPreferences: WeatherPreferences
    ): WeatherLocalDataSource = WeatherLocalDataSourceImpl(
        weatherPreferences = weatherPreferences,
    )

    @Provides
    fun provideWeatherRemoteDataSource(
        apiService: ApiService,
    ): WeatherRemoteDataSource = WeatherRemoteDataSourceImpl(
        api = apiService
    )

}