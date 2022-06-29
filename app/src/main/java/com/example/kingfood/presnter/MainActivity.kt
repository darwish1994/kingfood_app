package com.example.kingfood.presnter

import com.example.kingfood.databinding.ActivityMainBinding
import com.example.kingfood.presnter.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initOnCreate() {
    }
}