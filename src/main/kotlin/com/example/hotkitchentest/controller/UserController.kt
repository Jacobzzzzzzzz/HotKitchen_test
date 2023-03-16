package com.example.hotkitchentest.controller

import com.example.hotkitchentest.model.dto.request.UserRequest
import com.example.hotkitchentest.model.entity.User
import com.example.hotkitchentest.service.userService.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/me")
class UserController(private val userService: UserService) {
    @GetMapping("/{id}")
    fun getUserInfo(@PathVariable id: Long): User = userService.getUserInfo(id)
    @PostMapping
    fun postUserInfo(@RequestBody request: UserRequest): User = userService.postUserInfo(request)
    @PutMapping("/{id}")
    fun updateUserInfo(@PathVariable id: Long, @RequestBody request: UserRequest): User = userService.updateUserInfo(id, request)
    @DeleteMapping("/{id}")
    fun deleteUserInfo(@PathVariable id: Long) = userService.deleteUserInfo(id)
}