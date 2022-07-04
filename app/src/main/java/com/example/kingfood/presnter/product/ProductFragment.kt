package com.example.kingfood.presnter.product

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kingfood.databinding.FragmentProductBinding
import com.example.kingfood.domain.model.Product
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.base.BaseFragmentMVVM
import com.example.kingfood.utils.loadFrom
import com.example.kingfood.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty

@AndroidEntryPoint
class ProductFragment : BaseFragmentMVVM<FragmentProductBinding, ProductViewModel>(),
    View.OnClickListener {

    private val arg by navArgs<ProductFragmentArgs>()

    override fun getViewBinding(): FragmentProductBinding =
        FragmentProductBinding.inflate(layoutInflater)

    override fun initListener() {
        binding.plusBnt.setOnClickListener(this)
        binding.minusBnt.setOnClickListener(this)
        binding.addToCartBtn.setOnClickListener(this)
    }

    override fun removeListener() {

        binding.plusBnt.setOnClickListener(null)
        binding.minusBnt.setOnClickListener(null)
        binding.addToCartBtn.setOnClickListener(null)
    }

    override fun initViewModel(): Lazy<ProductViewModel> = viewModels()

    override fun onCreateInit() {
        getInitViewModel().getProduct(arg.id)

        if (!getInitViewModel().productLiveData.hasActiveObservers())
            observe(getInitViewModel().productLiveData, ::productObserver)

        if (!getInitViewModel().cartLiveData.hasActiveObservers())
            observe(getInitViewModel().cartLiveData, ::cartObserver)
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            binding.plusBnt.id -> plus()
            binding.minusBnt.id -> minus()
            binding.addToCartBtn.id -> {
                getInitViewModel().addToCart(
                    arg.id,
                    binding.counterTv.text.toString().toFloat().toInt()
                )
            }

        }

    }


    private fun productObserver(it: Resource<ResponseWrapper<Product>>?) {
        it?.let {
            when (it) {

                is Resource.Loading -> showLoading()
                is Resource.Success -> {
                    dismissLoading()
                    it.data?.data?.let { pro ->
                        binding.productImage.loadFrom(pro.image)
                        binding.productName.text = pro.name
                        binding.productPrice.text = "${pro.price} EGP"
                        binding.productDetails.text = pro.details

                        if (pro.quantity > 1)
                            binding.counterTv.text = pro.quantity.toString()


                    }

                }
                is Resource.Error -> {
                    Toasty.error(requireActivity(), it.message ?: "something went wrong").show()
                    findNavController().popBackStack()


                }
            }

        }


    }

    private fun cartObserver(it: Resource<ResponseWrapper<String>>?) {
        it?.let {
            when (it) {

                is Resource.Loading -> showLoading()
                is Resource.Success -> {
                    dismissLoading()
                }
                is Resource.Error -> {
                    Toasty.error(requireActivity(), it.message ?: "something went wrong").show()
                }
            }

        }


    }


    private fun plus() {
        binding.counterTv.text.toString().toFloatOrNull()?.let {
            binding.counterTv.text = (it + 1f).toString()
        }
    }

    private fun minus() {
        binding.counterTv.text.toString().toFloatOrNull()?.let {
            if (it - 1f >= 1)
                binding.counterTv.text = (it - 1f).toString()
        }
    }

}