package com.example.kingfood.presnter.cart.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingfood.databinding.ItemLayoutCartItemBinding
import com.example.kingfood.databinding.ItemLayoutProductBinding
import com.example.kingfood.domain.model.CartItem
import com.example.kingfood.domain.model.Product
import com.example.kingfood.utils.CartCallBack
import com.example.kingfood.utils.ProductCallBack
import com.example.kingfood.utils.loadFrom

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val dataList = arrayListOf<CartItem>()
    var listener: CartCallBack? = null


    fun update(it: List<CartItem>) {
        dataList.apply {
            clear()
            addAll(it)
        }
        notifyDataSetChanged()
    }


    inner class CartViewHolder(private val layout: ItemLayoutCartItemBinding) :
        RecyclerView.ViewHolder(layout.root) {
        private lateinit var cartItem: CartItem

        init {
            layout.removeBtn.setOnClickListener {
                if (::cartItem.isInitialized)
                    listener?.onClick(cartItem)

            }
        }


        fun bind(item: CartItem) {
            cartItem = item
            layout.productImage.loadFrom(item.image)
            layout.productName.text = item.name
            layout.productPrice.text = item.price.toString().plus(" EGP")
            layout.productQuantity.text = item.quantity.toString().plus(" item")

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder =
        CartViewHolder(
            ItemLayoutCartItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}