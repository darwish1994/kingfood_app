package com.example.kingfood.presnter.product

import com.example.kingfood.databinding.FragmentProductsBinding
import com.example.kingfood.utils.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment :BaseFragment<FragmentProductsBinding>() {
    override fun getViewBinding(): FragmentProductsBinding = FragmentProductsBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun removeListener() {
    }
}