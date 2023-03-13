package com.example.hotkitchentest.model.repository

import com.example.hotkitchentest.model.entity.Booking
import org.springframework.data.repository.CrudRepository

interface BookingRepository:CrudRepository<Booking,Long>