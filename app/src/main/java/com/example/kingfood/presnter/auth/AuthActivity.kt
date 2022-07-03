package com.example.kingfood.presnter.auth

import com.example.kingfood.databinding.ActivityAuthBinding
import com.example.kingfood.utils.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>() {
    override fun getViewBinding(): ActivityAuthBinding  = ActivityAuthBinding.inflate(layoutInflater)

    override fun initOnCreate() =Unit
}