package com.example.kingfood.presnter.auth

import android.content.Intent
import android.util.Patterns
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kingfood.R
import com.example.kingfood.databinding.FragmentLoginBinding
import com.example.kingfood.domain.model.User
import com.example.kingfood.presnter.MainActivity
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.base.BaseFragmentMVVM
import com.example.kingfood.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty

@AndroidEntryPoint
class LoginFragment : BaseFragmentMVVM<FragmentLoginBinding, AuthViewModel>(),
    View.OnClickListener {

    override fun getViewBinding(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

    override fun initListener() {
        binding.loginBtn.setOnClickListener(this)
        binding.registerBtn.setOnClickListener(this)
    }

    override fun removeListener() {
        binding.loginBtn.setOnClickListener(null)
        binding.registerBtn.setOnClickListener(null)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.loginBtn.id -> login()
            binding.registerBtn.id -> findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())

        }
    }


    private fun login() {
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.email.editText?.text.toString()).matches()) {
            binding.email.error = getString(R.string.email_error)
            return
        }
        if (binding.password.editText?.text.isNullOrBlank()) {
            binding.password.error = getString(R.string.password_error)
            return
        }

        getInitViewModel().login(
            binding.email.editText?.text.toString(),
            binding.password.editText?.text.toString()
        )

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


}