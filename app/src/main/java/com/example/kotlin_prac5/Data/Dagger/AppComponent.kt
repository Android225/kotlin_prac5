package com.example.kotlin_prac5.Data.Dagger

import com.example.kotlin_prac5.UI.View.Fragment1
import com.example.kotlin_prac5.UI.View.Fragment2
import dagger.Component
import javax.inject.Singleton

 // Компонент Dagger для управления зависимостями в приложении.
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    // Методы для внедрения зависимостей в различные фрагменты.
    fun inject(fragment1: Fragment1)
    fun inject(fragment2: Fragment2)
}
