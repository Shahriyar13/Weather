package com.github.shahriyar13.domain.entity

import java.util.*

data class DailyWeatherEntity(
    val date: Date,
    val sunRise: Long,
    val sunSet: Long,
    val temperature: TemperatureEntity,
    val feelsLike: FeelsLikeEntity,
    val pressure: Int,
    val humidity: Int,
    val dewPoint: Float,
    val windSpeed: Float,
    val windDegree: Int,
    val weatherDetailsList: List<WeatherDetailsEntity>,
    val clouds: Int,
    val uvi: Float,
)
