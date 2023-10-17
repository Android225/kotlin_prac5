package com.example.kotlin_prac5.UI.View

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.kotlin_prac5.Data.Dagger.AppComponent
import com.example.kotlin_prac5.Data.Dagger.AppModule
import com.example.kotlin_prac5.R
import com.example.kotlin_prac5.UI.StateHolder.ViewModel.MyViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    lateinit var appComponent: AppComponent
    // init pract5
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment1)


        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.data.observe(this, Observer { data ->
            // обновление UI с новыми данными
        })
    }
}