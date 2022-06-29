package com.example.kingfood.presnter.base

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentMVVM<VB : ViewBinding, VM : BaseViewModel> : BaseFragment<VB>() {
    val viewModel: VM by lazy { initViewModel().value }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateInit()
    }


    abstract fun initViewModel(): Lazy<VM>

    abstract fun onCreateInit()



}