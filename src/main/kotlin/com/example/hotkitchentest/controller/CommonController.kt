package com.example.hotkitchentest.controller

import com.example.hotkitchentest.model.dto.HealthResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CommonController {
    @GetMapping("/health")
    fun healthCheck()=HealthResponse().asResponse()
}