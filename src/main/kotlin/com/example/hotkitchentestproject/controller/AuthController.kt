package com.example.hotkitchentestproject.controller

import com.example.hotkitchentestproject.model.Message
import com.example.hotkitchentestproject.model.dto.LoginDTO
import com.example.hotkitchentestproject.model.dto.RegisterDTO
import com.example.hotkitchentestproject.model.entity.User
import com.example.hotkitchentestproject.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class AuthController(private val userService: UserService) {
    @PostMapping("register")
    fun register(@RequestBody body: RegisterDTO):ResponseEntity<User> {
        val user = User()
        user.name = body.name
        user.email = body.email
        user.password = body.password
        return ResponseEntity.ok(this.userService.save(user))
    }
    @PostMapping("login")
    fun login(@RequestBody body: LoginDTO):ResponseEntity<Any> {
        val user = this.userService.findByEmail(body.email)
            ?: return ResponseEntity.badRequest().body(Message("User not found!"))
        if (!user.comparePassword(body.password)) {
            return ResponseEntity.badRequest().body(Message("Wrong password!"))
        }
        return ResponseEntity.ok(user)
    }
}