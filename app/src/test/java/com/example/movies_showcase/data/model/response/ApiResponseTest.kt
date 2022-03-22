package com.example.movies_showcase.data.model.response

import com.example.movies_showcase.domain.model.exception.NetworkException
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ApiResponseTest {

    @Test
    fun `Given that api response is Success, when mapData is called, then should return new Success model with mapped data`() {
        val sut = ApiResponse.Success("1")

        val mappedValue = sut.mapData { it.toInt() }

        assertThat(mappedValue).isEqualTo(ApiResponse.Success(1))
    }

    @Test
    fun `Given that api response is Error, when mapData is called, then should return new Error model`() {
        val throwable = NetworkException("message")
        val sut = ApiResponse.Error<String>(throwable)

        val mappedValue = sut.mapData { it.toInt() }

        assertThat(mappedValue).isEqualTo(ApiResponse.Error<Int>(throwable))
    }
}
