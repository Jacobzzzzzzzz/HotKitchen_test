package com.example.hotkitchentest.model.dto

import com.example.hotkitchentest.model.entity.Booking
import jakarta.persistence.Column

class BookingRequest (
    var title:String,
    var description: String,
    var status: String
    ) {
    fun asEntity() = Booking(
        title = title,
        description = description,
        status = status
    )
}