package com.example.hotkitchentest.controller

import com.example.hotkitchentest.model.dto.request.BookingRequest
import com.example.hotkitchentest.model.entity.Booking
import com.example.hotkitchentest.service.bookingService.BookingService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bookings")
class BookingController(private val bookingService: BookingService) {
    @GetMapping
    fun list(): Iterable<Booking> = bookingService.list()

    @PostMapping
    fun create(@RequestBody request: BookingRequest): Booking = bookingService.create(request)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Booking = bookingService.findById(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: BookingRequest): Booking =
        bookingService.update(id, request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = bookingService.delete(id)
}