package com.zobaze.zobazerefractortask.data.backend.model

import retrofit2.HttpException
import retrofit2.Response

sealed class NetworkResult<T : Any?> {

    class Success<T : Any?>(val data: T) : NetworkResult<T>()
    class Exception<T : Any?>(val exception: Throwable) : NetworkResult<T>()
    class Error<T : Any?>(
        val code: Int? = null,
        val message: String? = null
    ) : NetworkResult<T>()
}

suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResult.Success(body)
        } else {
            NetworkResult.Error(response.code(), response.message())
        }
    } catch (e: HttpException) {
        NetworkResult.Error(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        NetworkResult.Exception(e)
    }
}
