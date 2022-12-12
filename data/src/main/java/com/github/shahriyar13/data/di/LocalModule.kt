package com.github.shahriyar13.data.di

import android.content.Context
import android.content.SharedPreferences
import com.github.shahriyar13.data.local.pref.WeatherPreferences
import com.github.shahriyar13.data.local.pref.WeatherPreferencesImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalModule {

    @Provides
    @Singleton
    fun provideJsonConverter(): Gson = Gson()

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences =
        context.getSharedPreferences("weather_app_", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideWeatherAppPreferences(
        sharedPreferences: SharedPreferences,
        gson: Gson,
    ): WeatherPreferences = WeatherPreferencesImpl(
        sharedPreferences = sharedPreferences,
        jsonConverter = gson
    )
}