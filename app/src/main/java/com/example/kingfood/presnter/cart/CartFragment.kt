package com.example.kingfood.presnter.cart

import android.view.View
import androidx.fragment.app.viewModels
import com.example.kingfood.databinding.FragmentCartBinding
import com.example.kingfood.domain.model.CartItem
import com.example.kingfood.presnter.cart.list.CartAdapter
import com.example.kingfood.presnter.home.HomeViewModel
import com.example.kingfood.utils.CartCallBack
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.base.BaseFragmentMVVM
import com.example.kingfood.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty

@AndroidEntryPoint
class CartFragment : BaseFragmentMVVM<FragmentCartBinding, HomeViewModel>(), CartCallBack {

    private val adapter by lazy { CartAdapter() }

    override fun getViewBinding(): FragmentCartBinding = FragmentCartBinding.inflate(layoutInflater)

    override fun initListener() {
        binding.submitBtn.setOnClickListener {
            if (adapter.itemCount == 0) {
                Toasty.error(requireActivity(), "cart is Empty").show()
                return@setOnClickListener
            }

            getInitViewModel().createOrder()
        }
        binding.cartRec.adapter = adapter
        adapter.listener = this
    }

    override fun removeListener() {
        binding.cartRec.adapter = null
        adapter.listener = null

    }

    override fun initViewModel(): Lazy<HomeViewModel> = viewModels()

    override fun onCreateInit() {
        if (!getInitViewModel().cartLiveData.hasActiveObservers())
            observe(getInitViewModel().cartLiveData, ::cartObserver)

        if (!getInitViewModel().orderLiveData.hasActiveObservers())
            observe(getInitViewModel().orderLiveData, ::orderObserver)

        getInitViewModel().getCart()
    }


    override fun onClick(cartItem: CartItem) {
        getInitViewModel().removeFromCart(cartItem.id)
    }


    private fun cartObserver(it: Resource<ResponseWrapper<List<CartItem>>>?) {
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

    private fun orderObserver(it: Resource<ResponseWrapper<String>>?) {
        it?.let {
            when (it) {

                is Resource.Loading -> showLoading()
                is Resource.Success -> {
                    dismissLoading()
                    Toasty.success(requireActivity(), it.message ?: "Order Created").show()
                    getInitViewModel().getCart()
                }
                is Resource.Error -> {
                    dismissLoading()
                    Toasty.error(requireActivity(), it.message ?: "Something went wrong").show()
                }
            }
        }

    }


}