package com.example.kotlin_prac5.UI.View

import android.annotation.SuppressLint
import android.app.Application
import com.example.kotlin_prac5.Data.Dagger.AppComponent
import com.example.kotlin_prac5.Data.Dagger.AppModule
import com.example.kotlin_prac5.Data.Dagger.DaggerAppComponent

class MyApp : Application() {

    lateinit var appComponent: AppComponent

    @SuppressLint("MissingInflatedId")
    override fun onCreate() {
        super.onCreate()

        // Создание компонента Dagger.
        // Этот компонент будет использоваться для внедрения зависимостей.
        appComponent = DaggerAppComponent.builder()
            // Привязка модуля Dagger, который предоставляет зависимости.
            .appModule(AppModule(this))
            .build()
    }
}
