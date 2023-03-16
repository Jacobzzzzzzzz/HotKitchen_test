package com.example.hotkitchentest.model.dto.request

import com.example.hotkitchentest.model.entity.Meal

class MealRequest (
    var title: String,
    var price: Float,
    var imageUrl: String,
    var categoryIds: Array<Int>
) {
    fun asEntity() = Meal(
        title = title,
        price = price,
        imageUrl = imageUrl,
        categoryIds = categoryIds
    )
}