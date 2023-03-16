package com.example.hotkitchentest.model.dto.exception

import com.example.hotkitchentest.model.dto.response.ApiResponse
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.http.HttpStatus
import java.time.LocalDateTime
@JsonIgnoreProperties("cause","stackTrace","suppressed", "localizedMessage")
sealed class ServerException(
    override val status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    override val message: String = "Something went wrong!",
    override val timestamp: LocalDateTime = LocalDateTime.now()
) : ApiResponse, Throwable() {
    class NotFound(override val message: String = "Not found") : ServerException(HttpStatus.NOT_FOUND, message)
    class Forbidden(override val message: String = "Forbidden") : ServerException(HttpStatus.FORBIDDEN, message)
    class Unauthorized(override val message: String = "Unauthorized") : ServerException(HttpStatus.UNAUTHORIZED, message)
}