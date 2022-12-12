package com.github.shahriyar13.data.remote.model.mapper

import com.github.shahriyar13.data.remote.model.dto.*
import com.github.shahriyar13.domain.entity.*
import java.util.*

fun CurrentWeatherDto.mapToEntity() = CurrentWeatherEntity(
    date = Date(dt),
    sunRise = sunrise,
    sunSet = sunset,
    temperature = temp,
    feelsLike = feels_like,
    pressure = pressure,
    humidity = humidity,
    dewPoint = dew_point,
    windSpeed = wind_speed,
    windDegree = wind_deg,
    weatherDetailsList = weather.map { it.mapToEntity() },
    clouds = clouds,
    visibility = visibility,
    uvi = uvi,
)

fun DailyWeatherDto.mapToEntity() = DailyWeatherEntity(
    date = Date(dt),
    sunRise = sunrise,
    sunSet = sunset,
    temperature = temp.mapToEntity(),
    feelsLike = feels_like.mapToEntity(),
    pressure = pressure,
    humidity = humidity,
    dewPoint = dew_point,
    windSpeed = wind_speed,
    windDegree = wind_deg,
    weatherDetailsList = weather.map { it.mapToEntity() },
    clouds = clouds,
    uvi = uvi,
)

fun WeatherDetailsDto.mapToEntity() = WeatherDetailsEntity(
    id = id,
    main = main,
    description = description,
    icon = icon,
)

fun FeelsLikeDto.mapToEntity() = FeelsLikeEntity(
    day = day,
    morning = morn,
    evening = eve,
    night = night,
)

fun TemperatureDto.mapToEntity() = TemperatureEntity(
    day = day,
    morning = morn,
    evening = eve,
    night = night,
    min = min,
    max = max,
)