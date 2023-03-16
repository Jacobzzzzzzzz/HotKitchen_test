package com.example.hotkitchentest.model.dto.request

import com.example.hotkitchentest.model.entity.User


class UserRequest (
    var email:String,
    var username: String,
    var phoneNumber: String
) {
    fun asEntity() = User(
        email = email,
        username = username,
        phoneNumber = phoneNumber
    )
}