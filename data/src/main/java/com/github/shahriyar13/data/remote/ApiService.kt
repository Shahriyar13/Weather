package com.github.shahriyar13.data.remote

import com.github.shahriyar13.data.BuildConfig
import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.entity.enum.TemperatureUnitEnum
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val defaultApiVersion = "2.5"

interface ApiService {

    @GET("$defaultApiVersion/onecall")
    suspend fun getOneCallForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("exclude") exclude: String = "minutely,hourly",
        @Query("units") unit: TemperatureUnitEnum = TemperatureUnitEnum.Celsius, //TODO: choose by user
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): Response<OneCallApiResponse>
}