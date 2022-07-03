package com.example.kingfood.utils.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseActivityMVVM<VB : ViewBinding, VM : BaseViewModel> : BaseActivity<VB>() {

    private lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservables()
        //        Timber.v("HHHH %s", getViewModel().i) use common base BaseViewModel functionality
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this).get(getViewModelClass()) as VM
    }

    protected fun getViewModel(): VM {
        if (!::viewModel.isInitialized)
            initializeViewModel()
        return viewModel
    }

    protected abstract fun getViewModelClass(): Class<out BaseViewModel>

    protected abstract fun initObservables()
}