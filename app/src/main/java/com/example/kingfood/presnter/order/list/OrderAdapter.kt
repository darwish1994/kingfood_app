package com.example.kingfood.presnter.order.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingfood.databinding.ItemLayoutCartItemBinding
import com.example.kingfood.databinding.ItemLayoutOrderBinding
import com.example.kingfood.databinding.ItemLayoutOrderItemBinding
import com.example.kingfood.databinding.ItemLayoutProductBinding
import com.example.kingfood.domain.model.CartItem
import com.example.kingfood.domain.model.Item
import com.example.kingfood.domain.model.Order
import com.example.kingfood.domain.model.Product
import com.example.kingfood.utils.CartCallBack
import com.example.kingfood.utils.ProductCallBack
import com.example.kingfood.utils.loadFrom

class OrderAdapter : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    private val dataList = arrayListOf<Order>()


    fun update(it: List<Order>) {
        dataList.apply {
            clear()
            addAll(it)
        }
        notifyDataSetChanged()
    }


    inner class OrderViewHolder(private val layout: ItemLayoutOrderBinding) :
        RecyclerView.ViewHolder(layout.root) {
        private val adapter by lazy { OrderItemAdapter() }


        fun bind(item: Order) {
            layout.orderIdTv.text = "#${item.id}"
            layout.orderTotalTv.text = "${item.total} EGP"
            layout.orderItemRec.adapter = adapter
            adapter.update(item.items)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder =
        OrderViewHolder(
            ItemLayoutOrderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}