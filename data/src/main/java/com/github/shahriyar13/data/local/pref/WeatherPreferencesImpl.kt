package com.github.shahriyar13.data.local.pref

import android.content.SharedPreferences
import com.github.shahriyar13.domain.AppResult
import com.google.gson.Gson
import javax.inject.Inject

class WeatherPreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val jsonConverter: Gson
): WeatherPreferences {

    override suspend fun <T> readList(key: String, javaClass: Class<T>): AppResult<List<T>> {
        val list = sharedPreferences.getStringSet(key, null)

        try {
            list?.let { data ->
                val mappedList = data.map { jsonConverter.fromJson(it, javaClass) }
                return AppResult.Success(mappedList)
            }
            return AppResult.Error(Exception("No value"))
        } catch (e: Exception) {
            return AppResult.Error(e)
        }
    }

    override suspend fun <T> read(key: String, javaClass: Class<T>): AppResult<T> {
        val value = sharedPreferences.getString(key, null)

        try {
            value?.let {
                return AppResult.Success(jsonConverter.fromJson(value, javaClass))
            }
            return AppResult.Error(Exception("No value"))
        } catch (e: Exception) {
            return AppResult.Error(e)
        }
    }

    override suspend fun <T> save(key: String, value: T) {
        sharedPreferences.edit().putString(key, jsonConverter.toJson(value)).apply()
    }

    override suspend fun <T> save(key: String, value: List<T>) {
        val list = value.map { jsonConverter.toJson(value) }.toSet()
        sharedPreferences.edit().putStringSet(key, list).apply()
    }
}