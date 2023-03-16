package com.example.hotkitchentest.utils

import com.example.hotkitchentest.model.dto.exception.ServerException
import com.example.hotkitchentest.model.dto.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionResolver {
    @ExceptionHandler
    fun handle(exception: ServerException): ResponseEntity<String> {
        return ResponseEntity(exception.message, exception.status)
    }
}