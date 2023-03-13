package com.example.hotkitchentest.utils

import com.example.hotkitchentest.model.dto.ApiResponse
import com.example.hotkitchentest.model.dto.InternalServerException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ExceptionResolver {
    private val logger = LoggerFactory.getLogger(ExceptionResolver::class.java)
    @ExceptionHandler(value =[Throwable::class])
    fun handle(cause: Throwable, request: WebRequest): ResponseEntity<ApiResponse> {
        logger.info(cause.stackTraceToString())
        return InternalServerException().asResponse()
    }
}