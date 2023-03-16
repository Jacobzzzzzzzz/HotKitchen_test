package com.example.hotkitchentest.model.dto.response

import com.example.hotkitchentest.model.dto.response.ApiResponse
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class HealthResponse : ApiResponse {
    override val status: HttpStatus = HttpStatus.OK
    override val message: String = "Api is working!"
    override val timestamp: LocalDateTime = LocalDateTime.now()
}