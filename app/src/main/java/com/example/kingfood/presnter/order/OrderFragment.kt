package com.example.kingfood.presnter.order

import com.example.kingfood.databinding.FragmentOrderBinding
import com.example.kingfood.utils.base.BaseFragment
import com.example.kingfood.utils.base.BaseFragmentMVVM

class OrderFragment : BaseFragment<FragmentOrderBinding>() {
    override fun getViewBinding(): FragmentOrderBinding = FragmentOrderBinding.inflate(layoutInflater)

    override fun initListener() {

    }

    override fun removeListener() {

    }
}