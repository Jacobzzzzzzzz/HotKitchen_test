package com.example.hotkitchentest.model.dto.request

import com.example.hotkitchentest.model.entity.Booking

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