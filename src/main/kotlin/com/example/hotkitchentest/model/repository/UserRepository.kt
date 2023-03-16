package com.example.hotkitchentest.model.repository

import com.example.hotkitchentest.model.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository:CrudRepository<User,Long>