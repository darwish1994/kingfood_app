package com.example.kingfood.presnter.order

import androidx.fragment.app.viewModels
import com.example.kingfood.databinding.FragmentOrderBinding
import com.example.kingfood.domain.model.Order
import com.example.kingfood.presnter.order.list.OrderAdapter
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.base.BaseFragment
import com.example.kingfood.utils.base.BaseFragmentMVVM
import com.example.kingfood.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty

@AndroidEntryPoint
class OrderFragment : BaseFragmentMVVM<FragmentOrderBinding, OrderViewModel>() {
    private val adapter by lazy { OrderAdapter() }
    override fun getViewBinding(): FragmentOrderBinding =
        FragmentOrderBinding.inflate(layoutInflater)

    override fun initListener() {
        binding.orderRec.adapter = adapter

    }

    override fun removeListener() {
        binding.orderRec.adapter = null
    }

    override fun initViewModel(): Lazy<OrderViewModel> = viewModels()

    override fun onCreateInit() {
        getInitViewModel().getOrder()
        if (!getInitViewModel().orderLiveData.hasActiveObservers())
            observe(getInitViewModel().orderLiveData, ::orderObserver)
    }

    private fun orderObserver(it: Resource<ResponseWrapper<List<Order>>>?) {
        it?.let {
            when (it) {
                is Resource.Loading -> showLoading()
                is Resource.Success -> {
                    dismissLoading()
                    it.data?.data?.let { it1 -> adapter.update(it1) }

                }
                is Resource.Error -> {
                    dismissLoading()
                    Toasty.error(requireActivity(), it.message ?: "Something went wrong").show()
                }
            }

        }
    }

}