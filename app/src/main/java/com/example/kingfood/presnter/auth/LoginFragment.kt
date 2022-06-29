package com.example.kingfood.presnter.auth

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.kingfood.databinding.FragmentLoginBinding
import com.example.kingfood.presnter.base.BaseFragment


class LoginFragment : BaseFragment<FragmentLoginBinding>(), View.OnClickListener {
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
            binding.loginBtn.id -> {}
            binding.registerBtn.id -> findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())

        }
    }
}