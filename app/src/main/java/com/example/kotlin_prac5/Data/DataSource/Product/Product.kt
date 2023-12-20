package com.example.kotlin_prac5.Data.DataSource.Product

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Сущность "Продукт" для базы данных Room.
 * Теперь содержит дополнительное поле 'price' для цены продукта.
 */
@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    var id: Int,            // Уникальный идентификатор продукта
    var title: String,      // Название продукта
    var price: Double       // Цена продукта
)