package com.example.movies_showcase.domain.model.exception

data class NetworkException(override val message: String) : Exception()
