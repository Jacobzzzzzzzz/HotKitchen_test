package com.example.hotkitchentest.service.mealService

import com.example.hotkitchentest.model.dto.request.MealRequest
import com.example.hotkitchentest.model.entity.Meal

interface MealService {
    fun addMeal(request: MealRequest): Meal
    fun getMeals(): Iterable<Meal>
    fun getMealById(id: Long): Meal
}