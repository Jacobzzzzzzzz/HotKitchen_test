package com.example.hotkitchentest.controller

import com.example.hotkitchentest.model.dto.BookingRequest
import com.example.hotkitchentest.model.entity.Booking
import com.example.hotkitchentest.model.repository.BookingRepository
import com.example.hotkitchentest.service.BookingService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookingController(private val bookingService: BookingService) {
    @GetMapping("/bookings")
        fun list(): Iterable<Booking> = bookingService.list()
    @PostMapping("/bookings")
    fun create(@RequestBody request: BookingRequest): Booking = bookingService.create(request)
    @GetMapping("/bookings/{id}")
    fun findById(@PathVariable id: Long): Booking = bookingService.findById(id)
    @PutMapping("/bookings/{id}")
    fun update(@PathVariable id: Long,@RequestBody request: BookingRequest): Booking = bookingService.update(id, request)
    @DeleteMapping("/bookings/{id}")
    fun delete(@PathVariable id: Long) = bookingService.delete(id)
}