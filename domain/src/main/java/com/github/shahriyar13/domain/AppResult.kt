package com.github.shahriyar13.domain

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class AppResult<out R> {
    data class Success<out T>(val data: T) : AppResult<T>()
    data class Error(val exception: Exception) : AppResult<Nothing>()
    object Loading : AppResult<Nothing>()
}

val <T> AppResult<T>.data: T?
    get() = (this as? AppResult.Success)?.data
