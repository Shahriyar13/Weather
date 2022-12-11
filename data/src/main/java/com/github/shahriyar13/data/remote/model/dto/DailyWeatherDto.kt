package com.github.shahriyar13.data.remote.model.dto

data class DailyWeatherDto(
    val clouds: Int,
    val dew_point: Float,
    val dt: Long,
    val feels_like: FeelsLikeDto,
    val humidity: Int,
    val moon_phase: Float,
    val moonrise: Long,
    val moonset: Long,
    val pop: Float,
    val pressure: Int,
    val rain: Float,
    val sunrise: Long,
    val sunset: Long,
    val temp: TemperatureDto,
    val uvi: Float,
    val weather: List<WeatherDetailsDto>,
    val wind_deg: Int,
    val wind_gust: Float,
    val wind_speed: Float
)