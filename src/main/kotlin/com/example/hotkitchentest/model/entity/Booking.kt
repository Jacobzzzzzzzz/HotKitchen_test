package com.example.hotkitchentest.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Booking(
    @Column(nullable = false)
    var title:String,
    @Column(nullable = false)
    var description: String,
    @Column(nullable = false)
    var status: String
) : AbstractEntity()