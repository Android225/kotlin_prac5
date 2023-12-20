package com.example.kotlin_prac5.Data.DataSource.Product

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Абстрактный класс для базы данных Room.
 * Теперь поддерживает миграции для обновлений структуры базы данных.
 */
@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                )
                    // .addMigrations(MIGRATION_1_2) // Пример добавления миграции
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}