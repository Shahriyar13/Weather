package com.github.shahriyar13.domain.entity

import java.util.*

data class CurrentWeatherEntity(
    val date: Date,
    val sunRise: Long,
    val sunSet: Long,
    val temperature: Float,
    val feelsLike: Float,
    val pressure: Int,
    val humidity: Int,
    val dewPoint: Float,
    val windSpeed: Float,
    val windDegree: Int,
    val weatherDetailsList: List<WeatherDetailsEntity>,
    val clouds: Int,
    val visibility: Int,
    val uvi: Float,
)
