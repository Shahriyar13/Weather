package com.github.shahriyar13.domain.usecase

import com.github.shahriyar13.domain.AppResult

abstract class BaseUseCase<in P,out R> {
    /** Executes the use case asynchronously and returns a [AppResult].
     *
     * @return a [AppResult].
     *
     * @param parameters the input parameters to run the use case with
     */
    suspend operator fun invoke(parameters: P): R = execute(parameters)

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}