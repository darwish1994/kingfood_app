package com.example.kingfood.presnter.auth

import com.example.kingfood.databinding.ActivityAuthBinding
import com.example.kingfood.utils.base.BaseActivity

class AuthActivity : BaseActivity<ActivityAuthBinding>() {
    override fun getViewBinding(): ActivityAuthBinding  = ActivityAuthBinding.inflate(layoutInflater)

    override fun initOnCreate() =Unit
}