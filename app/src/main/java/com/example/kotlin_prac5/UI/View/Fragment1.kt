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

    @Inject
    lateinit var productRepository: ProductRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as MyApplication).appComponent.inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment1, container, false)

        val buttonToFragment2 = view.findViewById<Button>(R.id.button_to_fragment2)
        val buttonToFragment3 = view.findViewById<Button>(R.id.button_to_fragment3)

        buttonToFragment2.setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment2)
        }

        buttonToFragment3.setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment3)
        }
        return view
    }
}

