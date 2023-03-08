package com.example.hotkitchentestproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class HotKitchenTestProjectApplication

fun main(args: Array<String>) {
    runApplication<HotKitchenTestProjectApplication>(*args)
}
