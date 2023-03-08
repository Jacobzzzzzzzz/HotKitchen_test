package com.example.hotkitchentestproject.model.repository

import com.example.hotkitchentestproject.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<User,Int> {
    fun findByEmail(email:String):User?
}