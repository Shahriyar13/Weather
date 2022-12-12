package com.github.shahriyar13.weather.features.daily

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.shahriyar13.domain.entity.DailyWeatherEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DailyWeatherViewModel @Inject constructor(): ViewModel() {
    var dayWeather = mutableStateOf<DailyWeatherEntity?>(null)
    var date = mutableStateOf("")
    var humidity = mutableStateOf("")
    var uvi = mutableStateOf("")
    var weatherType = mutableStateOf("")
    var tempMorning = mutableStateOf("")
    var tempDay = mutableStateOf("")
    var tempEvening = mutableStateOf("")
    var tempNight = mutableStateOf("")
    var tempHigh = mutableStateOf("")
    var tempLow = mutableStateOf("")
    var imgUrl = mutableStateOf("")

    init {
        loadDailyWeatherData()
    }

    fun loadDailyWeatherData() {
        date.value = dayWeather.value!!.date.toString()
        weatherType.value = dayWeather.value!!.weatherDetailsList.first().main
        humidity.value = dayWeather.value!!.humidity.toString()
        uvi.value = dayWeather.value!!.uvi.toString()
        tempMorning.value = dayWeather.value!!.temperature.morning.toString()
        tempDay.value = dayWeather.value!!.temperature.day.toString()
        tempEvening.value = dayWeather.value!!.temperature.evening.toString()
        tempNight.value = dayWeather.value!!.temperature.night.toString()
        tempHigh.value = dayWeather.value!!.temperature.max.toString()
        tempLow.value = dayWeather.value!!.temperature.min.toString()
        imgUrl.value = dayWeather.value!!.weatherDetailsList.first().icon
    }
}