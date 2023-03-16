package com.example.hotkitchentest.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class User(
    @Column(nullable = false)
    var email: String,
    @Column(nullable = false)
    var username: String,
    @Column(nullable = false)
    var phoneNumber: String
): AbstractEntity()