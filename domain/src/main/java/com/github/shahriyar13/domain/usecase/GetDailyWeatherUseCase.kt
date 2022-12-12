package com.github.shahriyar13.domain.usecase

import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.DailyWeatherEntity
import com.github.shahriyar13.domain.repository.WeatherRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetDailyWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
): BaseUseCase<Unit, List<DailyWeatherEntity>>() {
    override suspend fun execute(parameters: Unit): AppResult<List<DailyWeatherEntity>> =
        weatherRepository.getDailyWeather()
}