package com.example.kingfood.presnter.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseActivityMVVM<VB : ViewBinding, VM : BaseViewModel> : BaseActivity<VB>() {

    protected val viewModel: VM by lazy { ViewModelProvider(this).get(getViewModelClass()) as VM }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObservers()
    }


    protected abstract fun getViewModelClass(): Class<out BaseViewModel>

    protected abstract fun initObservers()
}