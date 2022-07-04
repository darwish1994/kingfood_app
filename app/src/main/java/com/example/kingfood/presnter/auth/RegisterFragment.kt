package com.example.kingfood.presnter.auth

import android.content.Intent
import android.util.Patterns
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kingfood.R
import com.example.kingfood.databinding.FragmentRegisterBinding
import com.example.kingfood.domain.model.User
import com.example.kingfood.presnter.MainActivity
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.base.BaseFragmentMVVM
import com.example.kingfood.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty

@AndroidEntryPoint
class RegisterFragment : BaseFragmentMVVM<FragmentRegisterBinding, AuthViewModel>(),
    View.OnClickListener {

    override fun getViewBinding(): FragmentRegisterBinding =
        FragmentRegisterBinding.inflate(layoutInflater)

    override fun initListener() {
        binding.registerBtn.setOnClickListener(this)
        binding.loginBtn.setOnClickListener(this)
    }

    override fun removeListener() {
        binding.registerBtn.setOnClickListener(null)
        binding.loginBtn.setOnClickListener(null)
    }

    override fun initViewModel(): Lazy<AuthViewModel> = viewModels()

    override fun onCreateInit() {
        observe(getInitViewModel().authLiveData, ::authObserver)
    }

    private fun authObserver(it: Resource<ResponseWrapper<User>>?) {
        it?.let {

            when (it) {
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Success -> {
                    dismissLoading()
                    startActivity(Intent(requireActivity(), MainActivity::class.java))
                    activity?.finish()
                }
                is Resource.Error -> {
                    dismissLoading()
                    it.message?.let { it1 ->
                        Toasty.error(
                            requireActivity(),
                            it1,
                            Toasty.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        }

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.loginBtn.id -> if (!findNavController().popBackStack())
                activity?.finish()

            binding.registerBtn.id -> register()
        }
    }

    private fun register() {

        if (binding.name.editText?.text.isNullOrBlank()) {
            binding.name.error = getString(R.string.required)
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.email.editText?.text.toString()).matches()) {
            binding.email.error = getString(R.string.email_error)
            return
        }
        if (!Patterns.PHONE.matcher(binding.phone.editText?.text.toString()).matches()) {
            binding.email.error = getString(R.string.phone_error)
            return
        }
        if (binding.address.editText?.text.isNullOrBlank()) {
            binding.address.error = getString(R.string.required)
            return
        }
        if (binding.password.editText?.text.isNullOrBlank()) {
            binding.password.error = getString(R.string.password_error)
            return
        }

        getInitViewModel().register(
            name = binding.name.editText?.text.toString(),
            phone = binding.phone.editText?.text.toString(),
            email = binding.email.editText?.text.toString(),
            address = binding.address.editText?.text.toString(),
            password = binding.password.editText?.text.toString(),
        )

    }


}