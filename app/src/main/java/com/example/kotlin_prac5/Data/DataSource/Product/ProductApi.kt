package com.example.kotlin_prac5.Data.DataSource.Product

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Интерфейс для работы с API продуктов через Retrofit.
 * Добавлен метод для получения конкретного продукта по его ID.
 */
interface ProductApi {
    @GET("products")
    suspend fun getAllProduct(): Products

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") productId: Int): Product
}