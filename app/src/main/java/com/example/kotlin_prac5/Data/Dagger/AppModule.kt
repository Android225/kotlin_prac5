package com.example.kotlin_prac5.Data.Dagger

import android.app.Application
import com.example.kotlin_prac5.Data.DataSource.Product.ProductDao
import com.example.kotlin_prac5.Data.DataSource.Product.ProductDatabase
import com.example.kotlin_prac5.Data.DataSource.Product.ProductRepository
import com.example.kotlin_prac5.Data.DataSource.Product.ProductApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl("https://example.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Предоставление объекта API для работы с сетью.
    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit): ProductApi =
        retrofit.create(ProductApi::class.java)

    // Предоставление экземпляра базы данных Room.
    @Provides
    @Singleton
    fun provideProductDatabase(): ProductDatabase =
        ProductDatabase.getDatabase(application)

    // Предоставление DAO для доступа к данным в базе данных.
    @Provides
    @Singleton
    fun provideProductDao(database: ProductDatabase): ProductDao =
        database.productDao()

}
