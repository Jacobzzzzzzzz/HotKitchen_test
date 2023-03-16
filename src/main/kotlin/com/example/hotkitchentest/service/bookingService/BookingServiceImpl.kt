package com.example.hotkitchentest.service.bookingService

import com.example.hotkitchentest.model.dto.request.BookingRequest
import com.example.hotkitchentest.model.dto.exception.ServerException
import com.example.hotkitchentest.model.entity.Booking
import com.example.hotkitchentest.model.repository.BookingRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service

@Service
class BookingServiceImpl(
    private val bookingRepository: BookingRepository
): BookingService {
    override fun list(): Iterable<Booking> = bookingRepository.findAll()

    override fun create(request: BookingRequest): Booking {
        val booking = request.asEntity()
        return bookingRepository.save(booking)
    }
    override fun findById(id: Long): Booking = bookingRepository.findById(id).orElseThrow{ServerException.NotFound() }
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