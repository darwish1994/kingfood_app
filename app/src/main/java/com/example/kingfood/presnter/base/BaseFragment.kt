package com.example.kingfood.presnter.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    private var _binding: VB? = null

    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }



    override fun onResume() {
        super.onResume()
        initListener()
    }

    override fun onPause() {
        super.onPause()
        removeListener()
    }

    abstract fun getViewBinding(): VB?


    abstract fun initListener()
    abstract fun removeListener()


}