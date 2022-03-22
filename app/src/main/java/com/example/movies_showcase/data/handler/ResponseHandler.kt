package com.example.movies_showcase.data.handler

import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.domain.model.exception.NetworkException
import retrofit2.Response
import javax.inject.Inject

class ResponseHandler @Inject constructor() {

    suspend fun <T> handleApiCall(apiCall: suspend () -> Response<T>): ApiResponse<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                response.body()?.let {
                    return ApiResponse.Success(it)
                }
            }
            return ApiResponse.Error(NetworkException(response.message()))
        } catch (exception: Exception) {
            return ApiResponse.Error(exception)
        }
    }
}
