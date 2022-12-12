package com.github.shahriyar13.domain.usecase

import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.LocationEntity
import com.github.shahriyar13.domain.repository.WeatherRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetWeatherLocationUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
): BaseUseCase<LocationEntity, Unit>() {
    override suspend fun execute(parameters: LocationEntity): AppResult<Unit> {
        weatherRepository.setWeatherLocation(parameters)
        return AppResult.Success(Unit)
    }
}