package com.example.kingfood.presnter.menu

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kingfood.databinding.FragmentProductsBinding
import com.example.kingfood.domain.model.Product
import com.example.kingfood.presnter.home.HomeViewModel
import com.example.kingfood.presnter.menu.list.ProductAdapter
import com.example.kingfood.utils.ProductCallBack
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.base.BaseFragmentMVVM
import com.example.kingfood.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty

@AndroidEntryPoint
class ProductsFragment : BaseFragmentMVVM<FragmentProductsBinding, HomeViewModel>(),
    ProductCallBack {

    private val adapter by lazy { ProductAdapter() }
    override fun getViewBinding(): FragmentProductsBinding =
        FragmentProductsBinding.inflate(layoutInflater)

    override fun initListener() {
        binding.productRec.adapter = adapter
        adapter.listener = this
        binding.button.setOnClickListener {
            getInitViewModel().getAllProduct()
        }
    }

    override fun removeListener() {
        binding.productRec.adapter = null
        adapter.listener = null
    }

    override fun initViewModel(): Lazy<HomeViewModel> = viewModels()

    override fun onCreateInit() {
        getInitViewModel().getAllProduct()
        if (!getInitViewModel().productLiveData.hasActiveObservers())
            observe(getInitViewModel().productLiveData, ::productObserver)
    }


    private fun productObserver(it: Resource<ResponseWrapper<List<Product>>>?) {
        it?.let {
            when (it) {
                is Resource.Loading -> {
                    showLoading()
                    binding.button.visibility = View.GONE
                }
                is Resource.Success -> {
                    dismissLoading()
                    it.data?.data?.let { it1 -> adapter.update(it1) }

                }

                is Resource.Error -> {
                    dismissLoading()
                    Toasty.error(requireActivity(), it.message ?: "something went wrong").show()
                    binding.button.visibility = View.VISIBLE

                }


            }


        }


    }

    override fun onClick(product: Product) {
        findNavController().navigate(
            ProductsFragmentDirections.actionProductsFragmentToProductFragment(
                product.id
            )
        )
    }
}