package com.example.movies_showcase.data.model.response

sealed class ApiResponse<T> {

    abstract fun <D> mapData(mapper: (T) -> D): ApiResponse<D>

    data class Success<T>(val data: T) : ApiResponse<T>() {
        override fun <D> mapData(mapper: (T) -> D): ApiResponse<D> {
            return Success(mapper(data))
        }
    }

    data class Error<T>(val throwable: Throwable) : ApiResponse<T>() {
        override fun <D> mapData(mapper: (T) -> D): ApiResponse<D> {
            return Error(throwable)
        }
    }
}
