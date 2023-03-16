package com.example.hotkitchentest.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Meal(
    @Column(nullable = false)
    var title: String,
    @Column(nullable = false)
    var price: Float,
    @Column(nullable = false)
    var imageUrl: String,
    @Column(nullable = false)
    var categoryIds: Array<Int>
): AbstractEntity()