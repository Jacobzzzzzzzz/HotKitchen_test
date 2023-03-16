package com.example.hotkitchentest.model.repository

import com.example.hotkitchentest.model.entity.Meal
import org.springframework.data.repository.CrudRepository

interface MealRepository:CrudRepository<Meal,Long>