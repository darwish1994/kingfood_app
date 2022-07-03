package com.example.kingfood.utils.base

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.kingfood.databinding.DialogLoadingBinding
import com.example.kingfood.utils.DialogUtil

abstract class BaseFragmentMVVM<VB : ViewBinding, VM : BaseViewModel> : BaseFragment<VB>() {
    protected lateinit var viewModel: Lazy<VM>

    private val dialog by lazy {
        DialogUtil.showLoading(
            requireActivity(),
            DialogLoadingBinding.inflate(layoutInflater)
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = initViewModel()
        onCreateInit()
    }


    fun showLoading(){
        dialog.show()
    }

    fun dismissLoading(){
        dialog.dismiss()
    }

    abstract fun initViewModel(): Lazy<VM>

    abstract fun onCreateInit()

    fun getInitViewModel() = viewModel.value

}