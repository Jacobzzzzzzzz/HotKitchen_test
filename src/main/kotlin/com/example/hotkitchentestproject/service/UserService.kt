package com.example.hotkitchentestproject.service

import com.example.hotkitchentestproject.model.entity.User
import com.example.hotkitchentestproject.model.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun save(user: User): User {
        return this.userRepository.save(user)
    }
    fun findByEmail(email: String):User? {
        return this.userRepository.findByEmail(email)
    }
}