package com.example.movies_showcase.data.handler

import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.domain.model.exception.NetworkException
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import retrofit2.Response

class ResponseHandlerTest {

    private val sut = ResponseHandler()

    @Test
    fun `Given that response is error response, when handleApiCall is called, then should return Error`() =
        runBlocking {
            val response = Response.error<String>(400, "".toResponseBody())

            val handledValue = sut.handleApiCall { mockedApiCall(response) }

            assertThat(handledValue).isEqualTo(ApiResponse.Error<String>(NetworkException("Response.error()")))
        }

    @Test
    fun `Given that calling api throws exception, when handleApiCall is called, then should return Error`() =
        runBlocking {
            val exception = NetworkException("message")

            val handledValue = sut.handleApiCall<String> { mockedApiCall(exception) }

            assertThat(handledValue).isEqualTo(ApiResponse.Error<String>(NetworkException("message")))
        }

    @Test
    fun `Given that api returns value, when handleApiCall is called, then should return Success`() =
        runBlocking {
            val body = "body"
            val response = Response.success(body)

            val handledValue = sut.handleApiCall<String> { mockedApiCall(response) }

            assertThat(handledValue).isEqualTo(ApiResponse.Success(body))
        }

    private suspend fun <T> mockedApiCall(response: T): T {
        return response
    }

    private suspend fun <T> mockedApiCall(throwable: Throwable): T {
        throw throwable
    }
}
