package com.github.shahriyar13.data.network.model

data class DailyWeatherDto(val dt: Long,
                           val sunrise: Long,
                           val sunset: Long,
                           val moonrise: Long,
                           val moonset: Long,
                           val moon_phase: Float,
                           val temp: TemperatureDto,
                           val feels_like: FeelsLikeDto,
                           val pressure: Int,
                           val humidity: Int,
                           val dew_point: Float,
                           val wind_speed: Float,
                           val wind_deg: Int,
                           val weather: List<WeatherDetailsDto>,
                           val clouds: Int,
                           val pop: Float,
                           val rain: Float,
                           val uvi: Float,
) {
    data class TemperatureDto(
        val day: Float,
        val min: Float,
        val night: Float,
        val eve: Float,
        val morn: Float,
    )
    data class FeelsLikeDto(
        val day: Float,
        val night: Float,
        val eve: Float,
        val morn: Float,
    )
}