package com.example.kotlin_prac5.UI.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlin_prac5.Data.DataSource.Product.Product
import com.example.kotlin_prac5.UI.StateHolder.ViewModel.ProductVM
import com.example.kotlin_prac5.databinding.AddFragmentBinding


class AddFragment : Fragment() {

    private lateinit var binding: AddFragmentBinding
    private lateinit var viewModel: ProductVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AddFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ProductVM::class.java)

        binding.add.setOnClickListener {
            val tempName = binding.editTextName.text.toString()
            val tempPrice = binding.editTextPrice.text.toString().toDoubleOrNull()
            if (tempName.isNotEmpty() && tempPrice != null) {
                val product = Product(0, tempName, tempPrice)
                viewModel.addProduct(product)
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Please enter valid product details", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }
}