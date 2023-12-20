package com.example.kotlin_prac5.UI.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin_prac5.Data.DataSource.Product.ProductRepository
import com.example.kotlin_prac5.R
import javax.inject.Inject

class Fragment1 : Fragment() {

    // ProductRepository будет внедрен через Dagger.
    @Inject
    lateinit var productRepository: ProductRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Внедрение зависимостей с помощью Dagger.
        // MyApp - хранит компонент Dagger.
        // appComponent - компонент Dagger, который используется для внедрения зависимостей.
        (requireActivity().application as MyApp).appComponent.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment1, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Настройка обработчиков нажатий для кнопок в пользовательском интерфейсе.
        setupButtonListeners(view)
    }

    // Настраивает обработчики нажатий кнопок для перехода к другим фрагментам.
    private fun setupButtonListeners(view: View) {
        // Обработчик для кнопки, ведущей ко второму фрагменту.
        view.findViewById<Button>(R.id.button_to_fragment2).setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment2)
        }

        // Обработчик для кнопки, ведущей к третьему фрагменту.
        view.findViewById<Button>(R.id.button_to_fragment3).setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment3)
        }
    }
}
