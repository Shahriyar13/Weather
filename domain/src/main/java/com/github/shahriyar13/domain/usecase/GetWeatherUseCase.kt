package com.github.shahriyar13.domain.usecase

import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.CurrentWeatherEntity
import com.github.shahriyar13.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
): BaseUseCase<Unit, CurrentWeatherEntity>() {
    override suspend fun execute(parameters: Unit): AppResult<CurrentWeatherEntity> =
        weatherRepository.getCurrentWeather()
}