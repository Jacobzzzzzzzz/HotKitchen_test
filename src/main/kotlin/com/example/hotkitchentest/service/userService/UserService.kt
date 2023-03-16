package com.example.hotkitchentest.service.userService

import com.example.hotkitchentest.model.dto.request.UserRequest
import com.example.hotkitchentest.model.entity.User

interface UserService {
        fun getUserInfo(id: Long): User
        fun postUserInfo(request: UserRequest): User
        fun updateUserInfo(id: Long, request: UserRequest): User
        fun deleteUserInfo(id: Long)
}