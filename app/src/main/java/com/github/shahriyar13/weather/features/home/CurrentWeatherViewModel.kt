package com.github.shahriyar13.weather.features.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.shahriyar13.domain.AppResult
import com.github.shahriyar13.domain.entity.CurrentWeatherEntity
import com.github.shahriyar13.domain.entity.DailyWeatherEntity
import com.github.shahriyar13.domain.usecase.GetCurrentWeatherUseCase
import com.github.shahriyar13.domain.usecase.GetDailyWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getDailyWeatherUseCase: GetDailyWeatherUseCase,
) : ViewModel() {

    var dailyWeatherList = mutableStateOf<List<DailyWeatherEntity>>(listOf())
    var currentWeather = mutableStateOf<CurrentWeatherEntity?>(null)
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(true)
    var currentDate = mutableStateOf("")
    var currentWeatherType = mutableStateOf("")
    var currentTemp = mutableStateOf("")
    var currentImgUrl = mutableStateOf("")
    var currentHumidity = mutableStateOf("")
    var currentUV = mutableStateOf("")
    init {
        loadCurrentWeatherData()
        loadDailyWeatherData()
    }

    fun loadDailyWeatherData() {
        viewModelScope.launch {
            isLoading.value = true
            when (val result = getDailyWeatherUseCase.invoke(Unit)) {
                is AppResult.Success -> {
                    dailyWeatherList.value = result.data
                    loadError.value = ""
                    isLoading.value = false
                }

                is AppResult.Error -> {
                    loadError.value = result.exception.message!!
                    isLoading.value = false
                }
                else -> {}
            }
        }
    }

    fun loadCurrentWeatherData() {
        viewModelScope.launch {
            isLoading.value = true
            when (val result = getCurrentWeatherUseCase.invoke(Unit)) {
                is AppResult.Success -> {
                    currentWeather.value = result.data
                    currentDate.value = result.data.date.toString()
                    currentWeatherType.value = result.data.weatherDetailsList.first().main
                    currentTemp.value = result.data.temperature.toString()
                    currentImgUrl.value = result.data.weatherDetailsList.first().icon
                    currentHumidity.value = "${result.data.humidity}%"
                    currentUV.value = result.data.uvi.toString()
                    loadError.value = ""
                    isLoading.value = false
                }

                is AppResult.Error -> {
                    loadError.value = result.exception.message!!
                    isLoading.value = false
                }
                else -> {}
            }
        }

    }
}