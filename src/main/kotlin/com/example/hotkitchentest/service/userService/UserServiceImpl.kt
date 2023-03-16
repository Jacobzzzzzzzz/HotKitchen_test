package com.example.hotkitchentest.service.userService

import com.example.hotkitchentest.model.dto.exception.ServerException
import com.example.hotkitchentest.model.dto.request.BookingRequest
import com.example.hotkitchentest.model.dto.request.UserRequest
import com.example.hotkitchentest.model.entity.Booking
import com.example.hotkitchentest.model.entity.User
import com.example.hotkitchentest.model.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
        ):  UserService{
    override fun getUserInfo(id: Long): User = userRepository.findById(id).orElseThrow{ ServerException.NotFound() }
    override fun postUserInfo(request: UserRequest): User {
        val user = request.asEntity()
        return userRepository.save(user)
    }
    override fun updateUserInfo(id: Long, request: UserRequest): User {
        val user = getUserInfo(id).apply {
            username = request.username
            phoneNumber = request.phoneNumber
        }
        return userRepository.save(user)
    }
    override fun deleteUserInfo(id: Long) = userRepository.deleteById(id)
}