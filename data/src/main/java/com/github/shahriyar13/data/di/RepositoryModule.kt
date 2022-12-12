package com.github.shahriyar13.data.di

import com.github.shahriyar13.data.datasource.weather.WeatherLocalDataSource
import com.github.shahriyar13.data.datasource.weather.WeatherRemoteDataSource
import com.github.shahriyar13.data.repository.WeatherRepositoryImpl
import com.github.shahriyar13.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun provideWeatherRepository(
        weatherLocalDataSource: WeatherLocalDataSource,
        weatherRemoteDataSource: WeatherRemoteDataSource,
    ): WeatherRepository = WeatherRepositoryImpl(
        weatherLocalDataSource = weatherLocalDataSource,
        weatherRemoteDataSource = weatherRemoteDataSource,
    )

}