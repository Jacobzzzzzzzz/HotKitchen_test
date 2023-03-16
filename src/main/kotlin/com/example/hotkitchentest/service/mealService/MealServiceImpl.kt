package com.example.hotkitchentest.service.mealService

import com.example.hotkitchentest.model.dto.exception.ServerException
import com.example.hotkitchentest.model.dto.request.MealRequest
import com.example.hotkitchentest.model.entity.Meal
import com.example.hotkitchentest.model.repository.MealRepository
import org.springframework.stereotype.Service

@Service
class MealServiceImpl(private val mealRepository: MealRepository):MealService {
    override fun addMeal(request:MealRequest): Meal {
        val meal = request.asEntity()
        return mealRepository.save(meal)
    }
    override fun getMeals(): Iterable<Meal> = mealRepository.findAll()
    override fun getMealById(id: Long): Meal = mealRepository.findById(id).orElseThrow{ServerException.NotFound() }
}