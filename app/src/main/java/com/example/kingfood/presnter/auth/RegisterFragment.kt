package com.example.kingfood.presnter.auth

import com.example.kingfood.databinding.FragmentRegisterBinding
import com.example.kingfood.presnter.base.BaseFragment


class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    override fun getViewBinding(): FragmentRegisterBinding = FragmentRegisterBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun removeListener() {
    }
}