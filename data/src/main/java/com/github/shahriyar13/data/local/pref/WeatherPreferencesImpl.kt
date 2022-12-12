package com.github.shahriyar13.data.local.pref

import android.content.SharedPreferences
import com.github.shahriyar13.domain.AppResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class WeatherPreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val jsonConverter: Gson
): WeatherPreferences {

    override suspend fun <T> read(key: String): AppResult<T> {
        val value = sharedPreferences.getString(key, null)
        val type: Type = object: TypeToken<T>() {}.type

        try {
            value?.let {
                return AppResult.Success(jsonConverter.fromJson(value, type))
            }
            return AppResult.Error(Exception("No value"))
        } catch (e: Exception) {
            return AppResult.Error(e)
        }
    }

    override suspend fun <T> save(key: String, value: T) {
        sharedPreferences.edit().putString(key, jsonConverter.toJson(value)).apply()
    }
}