package com.example.hotkitchentest.controller

import com.example.hotkitchentest.model.dto.request.MealRequest
import com.example.hotkitchentest.model.entity.Meal
import com.example.hotkitchentest.service.mealService.MealService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MealController(private val mealService: MealService) {
    @PostMapping("/addMeal")
    fun addMeal(@RequestBody request:MealRequest): Meal = mealService.addMeal(request)
    @GetMapping("/meals")
    fun getMeals(): Iterable<Meal> = mealService.getMeals()
    @GetMapping("/meals/{id}")
    fun getMealById(@PathVariable id: Long): Meal = mealService.getMealById(id)
}