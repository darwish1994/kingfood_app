package com.example.kingfood.presnter.menu.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingfood.databinding.ItemLayoutProductBinding
import com.example.kingfood.domain.model.Product
import com.example.kingfood.utils.ProductCallBack
import com.example.kingfood.utils.loadFrom

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val dataList = arrayListOf<Product>()
    var listener: ProductCallBack? = null


    fun update(it: List<Product>) {
        dataList.apply {
            clear()
            addAll(it)
        }
        notifyDataSetChanged()
    }


    inner class ProductViewHolder(private val layout: ItemLayoutProductBinding) :
        RecyclerView.ViewHolder(layout.root) {
        private lateinit var product: Product

        init {
            layout.root.setOnClickListener {
                if (::product.isInitialized)
                    listener?.onClick(product)

            }
        }


        fun bind(item: Product) {
            product = item
            layout.imageView2.loadFrom(item.image)
            layout.productName.text = item.name
            layout.textView3.text = item.price.toString().plus(" EGP")

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ItemLayoutProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}