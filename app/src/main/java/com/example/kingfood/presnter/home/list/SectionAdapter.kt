package com.example.kingfood.presnter.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingfood.databinding.ItemLayoutSectionBinding
import com.example.kingfood.domain.model.Section
import com.example.kingfood.utils.loadFrom

class SectionAdapter : RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    private val dataList = arrayListOf<Section>()

    fun update(it: List<Section>) {
        dataList.apply {
            clear()
            addAll(it)
        }
        notifyDataSetChanged()
    }


    inner class SectionViewHolder(private val layout: ItemLayoutSectionBinding) :
        RecyclerView.ViewHolder(layout.root) {


        fun bind(item: Section) {
            layout.imageV.loadFrom(item.image)
            layout.titleTv.text = item.title
            layout.detailsTv.text = item.details

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder =
        SectionViewHolder(
            ItemLayoutSectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}