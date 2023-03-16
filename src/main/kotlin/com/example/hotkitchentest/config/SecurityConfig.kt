package com.example.hotkitchentest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class SecurityConfig {
     @Bean
     fun users(): UserDetailsService {
         val users = User.withDefaultPasswordEncoder()
         val user = users
             .username("user")
             .password("password")
             .roles("USER")
             .build()
         val admin = users
             .username("admin")
             .password("adminpassword")
             .roles("USER", "ADMIN")
             .build()
         return InMemoryUserDetailsManager(user, admin)
     }
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/").permitAll()
            .requestMatchers("/health").permitAll()
            .requestMatchers(HttpMethod.GET,"/bookings/{id}").hasRole("USER")
            .requestMatchers(HttpMethod.DELETE,"/bookings/{id}").hasRole("USER")
            .requestMatchers(HttpMethod.PUT,"/bookings/{id}").hasRole("USER")
            .requestMatchers(HttpMethod.POST,"/bookings").hasRole("USER")
            .requestMatchers(HttpMethod.GET,"/bookings").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and().build()
    }
}