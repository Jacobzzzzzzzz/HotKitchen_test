package com.example.hotkitchentest.model.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.http.HttpStatus
import java.time.LocalDateTime
@JsonIgnoreProperties("cause","stackTrace","suppressed", "localizedMessage")
class InternalServerException:ApiResponse,Throwable() {
    override val status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR
    override val message: String = "Something went wrong!"
    override val timestamp: LocalDateTime = LocalDateTime.now()

}