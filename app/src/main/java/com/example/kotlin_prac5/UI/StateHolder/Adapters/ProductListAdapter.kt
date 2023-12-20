package com.example.kotlin_prac5.UI.StateHolder.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_prac5.Data.DataSource.Product.Product
import com.example.kotlin_prac5.databinding.ProductRowBinding

/**
 * Адаптер для отображения списка продуктов в RecyclerView.
 * Теперь отображает цену продукта.
 */
class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    private var productList = emptyList<Product>()

    class MyViewHolder(val binding: ProductRowBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(products: List<Product>) {
        productList = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ProductRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder.binding) {
            idTxt.text = productList[position].id.toString()
            nameTxt.text = productList[position].title
            // Отображение цены продукта
            priceTxt.text = productList[position].price.toString()
        }
    }
}