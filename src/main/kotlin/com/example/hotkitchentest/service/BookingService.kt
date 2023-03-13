package com.example.hotkitchentest.service

import com.example.hotkitchentest.model.dto.BookingRequest
import com.example.hotkitchentest.model.entity.Booking

interface BookingService {
    fun list(): Iterable<Booking>
    fun create(request: BookingRequest): Booking
    fun findById(id: Long): Booking
    fun update(id: Long, request: BookingRequest): Booking
    fun delete(id: Long)
}