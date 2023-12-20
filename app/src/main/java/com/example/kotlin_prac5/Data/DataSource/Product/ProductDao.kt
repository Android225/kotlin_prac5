package com.example.kotlin_prac5.Data.DataSource.Product

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * DAO для работы с продуктами в базе данных.
 * Добавлен метод для удаления продукта из базы данных.
 */
@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun getAll(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(products: List<Product>)

    @Delete
    suspend fun delete(product: Product)
}