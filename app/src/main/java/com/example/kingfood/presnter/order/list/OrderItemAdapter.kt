package com.example.kingfood.presnter.order.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingfood.databinding.ItemLayoutCartItemBinding
import com.example.kingfood.databinding.ItemLayoutOrderItemBinding
import com.example.kingfood.databinding.ItemLayoutProductBinding
import com.example.kingfood.domain.model.CartItem
import com.example.kingfood.domain.model.Item
import com.example.kingfood.domain.model.Product
import com.example.kingfood.utils.CartCallBack
import com.example.kingfood.utils.ProductCallBack
import com.example.kingfood.utils.loadFrom

class OrderItemAdapter : RecyclerView.Adapter<OrderItemAdapter.OrderItemViewHolder>() {

    private val dataList = arrayListOf<Item>()


    fun update(it: List<Item>) {
        dataList.apply {
            clear()
            addAll(it)
        }
        notifyDataSetChanged()
    }


    inner class OrderItemViewHolder(private val layout: ItemLayoutOrderItemBinding) :
        RecyclerView.ViewHolder(layout.root) {


        fun bind(item: Item) {
            layout.productImage.loadFrom(item.image)
            layout.productName.text = item.name
            layout.productPrice.text = item.price.toString().plus(" EGP")
            layout.productQuantity.text = item.quantity.toString().plus(" item")

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemViewHolder =
        OrderItemViewHolder(
            ItemLayoutOrderItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: OrderItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}