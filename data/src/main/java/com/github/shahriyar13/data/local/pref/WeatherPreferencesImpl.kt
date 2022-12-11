package com.github.shahriyar13.data.local.pref

import android.content.SharedPreferences
import com.github.shahriyar13.data.remote.model.response.OneCallApiResponse
import com.github.shahriyar13.domain.AppResult
import com.google.gson.Gson
import javax.inject.Inject

class WeatherPreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val jsonConverter: Gson
) : WeatherPreferences {

    override suspend fun save(key: String, value: OneCallApiResponse) {
        sharedPreferences.edit().putString(key, jsonConverter.toJson(value)).apply()
    }

    override fun read(key: String): AppResult<OneCallApiResponse?> {
        val value = sharedPreferences.getString(key, null)
        value?.let {
            return AppResult.Success(jsonConverter.fromJson(value, OneCallApiResponse::class.java))
        }
        return AppResult.Error(Exception())//TODO: Change Error
    }

}