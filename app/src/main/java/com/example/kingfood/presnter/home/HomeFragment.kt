package com.example.kingfood.presnter.home

import androidx.fragment.app.viewModels
import com.example.kingfood.R
import com.example.kingfood.data.remote.response.HomeSection
import com.example.kingfood.databinding.FragmentHomeBinding
import com.example.kingfood.presnter.home.list.OfferAdapter
import com.example.kingfood.presnter.home.list.SectionAdapter
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.base.BaseFragment
import com.example.kingfood.utils.base.BaseFragmentMVVM
import com.example.kingfood.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class HomeFragment : BaseFragmentMVVM<FragmentHomeBinding, HomeViewModel>() {

    private val sectionAdapter by lazy { SectionAdapter() }
    private val offerAdapter by lazy { OfferAdapter() }


    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)


    override fun initViewModel(): Lazy<HomeViewModel> = viewModels()

    override fun onCreateInit() {


        runBlocking {
            getInitViewModel().getUserData().firstOrNull()?.let {
                binding.header.text = getString(R.string.wellcome_header, it.name)
            }
        }

        getInitViewModel().getHome()
        observe(getInitViewModel().homeLiveData, ::homeObserver)


    }

    private fun homeObserver(it: Resource<ResponseWrapper<HomeSection>>?) {
        it?.let {
            when (it) {
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Success -> {
                    dismissLoading()
                    it.data?.data?.section?.let { it1 -> sectionAdapter.update(it1) }
                    it.data?.data?.offer?.let { it1 -> offerAdapter.update(it1) }

                }
                is Resource.Error -> {
                    dismissLoading()
                }
            }


        }

    }


    override fun initListener() {
        binding.sectionRec.adapter = sectionAdapter
        binding.offerRec.adapter = offerAdapter

    }

    override fun removeListener() {
        binding.sectionRec.adapter = null
        binding.offerRec.adapter = null

    }

}