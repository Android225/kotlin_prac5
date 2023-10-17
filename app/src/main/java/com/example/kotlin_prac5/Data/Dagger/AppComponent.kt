package com.example.kotlin_prac5.Data.Dagger

import com.example.kotlin_prac5.UI.View.Fragment1
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: Fragment1) // Пример инъекции зависимостей во фрагмент
}