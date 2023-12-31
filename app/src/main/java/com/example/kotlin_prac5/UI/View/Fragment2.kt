package com.example.kotlin_prac5.UI.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_prac5.Data.DataSource.Product.ProductApi
import com.example.kotlin_prac5.Data.DataSource.Product.ProductRepository
import com.example.kotlin_prac5.R
import com.example.kotlin_prac5.UI.StateHolder.Adapters.ProductListAdapter
import com.example.kotlin_prac5.UI.StateHolder.ViewModel.ProductVM
import com.example.kotlin_prac5.databinding.Fragment2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Fragment2 : Fragment() {
    private lateinit var binding: Fragment2Binding
    private lateinit var mProductVM: ProductVM;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)
        mProductVM = ViewModelProvider(this).get(ProductVM::class.java)
        val retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val productApi = retrofit.create(ProductApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            val products = productApi.getAllProduct()

            mProductVM.addAllItem(products.products)


        }

        val adapter = ProductListAdapter()
        binding.resyclerView.layoutManager = LinearLayoutManager(requireContext())
        mProductVM.getAllData.observe(viewLifecycleOwner) { product ->
            adapter.setData(product)
        }
        binding.resyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_addFragment)
        }
        binding.buttonBackFragment2.setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_fragment1)
        }

        return binding.root
    }
}
