package com.github.shahriyar13.data.remote.model.response

import com.github.shahriyar13.data.remote.model.dto.CurrentWeatherDto
import com.github.shahriyar13.data.remote.model.dto.DailyWeatherDto

data class OneCallApiResponse(
    val current: CurrentWeatherDto,
    val daily: List<DailyWeatherDto>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)