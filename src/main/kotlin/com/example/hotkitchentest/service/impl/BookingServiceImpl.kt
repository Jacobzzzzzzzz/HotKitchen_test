package com.example.hotkitchentest.service.impl

import com.example.hotkitchentest.model.dto.BookingRequest
import com.example.hotkitchentest.model.dto.InternalServerException
import com.example.hotkitchentest.model.entity.Booking
import com.example.hotkitchentest.model.repository.BookingRepository
import com.example.hotkitchentest.service.BookingService
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service

@Service
class BookingServiceImpl(
    private val bookingRepository: BookingRepository
):BookingService {
    override fun list(): Iterable<Booking> = bookingRepository.findAll()

    override fun create(request: BookingRequest): Booking {
        val booking = request.asEntity()
        return bookingRepository.save(booking)
    }
    override fun findById(id: Long): Booking = bookingRepository.findById(id).orElseThrow{InternalServerException()}
    @Modifying
    override fun update(id: Long, request: BookingRequest): Booking {
       val booking = findById(id).apply {
            title = request.title
            description = request.description
            status = request.status
        }
        return bookingRepository.save(booking)
    }
@Modifying
    override fun delete(id: Long) = bookingRepository.deleteById(id)
}