package com.github.shahriyar13.data.remote.model.dto

data class CurrentWeatherDto(
    val clouds: Int,
    val dew_point: Float,
    val dt: Long,
    val feels_like: Float,
    val humidity: Int,
    val pressure: Int,
    val sunrise: Long,
    val sunset: Long,
    val temp: Float,
    val uvi: Float,
    val visibility: Int,
    val weather: List<WeatherDetailsDto>,
    val wind_deg: Int,
    val wind_speed: Float
)