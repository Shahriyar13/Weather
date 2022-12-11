package com.github.shahriyar13.data.remote

import com.github.shahriyar13.data.BuildConfig
import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
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
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): Response<OneCallApiResponse>
}