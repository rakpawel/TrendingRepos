package com.pawelrak.trendingrepos.usecase

sealed class Result<T> {
    data class Progress<T>(var loading: Boolean) : Result<T>()
    data class Success<T>(var data: T) : Result<T>()
    data class Failure<T>(val e: Throwable) : Result<T>()
}