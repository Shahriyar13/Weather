package com.github.shahriyar13.data.network.model.response

import com.github.shahriyar13.data.network.model.DailyWeatherDto

data class OneCallApiResponse(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Long,
    val current: DailyWeatherDto,
    val daily: List<DailyWeatherDto>?,
)