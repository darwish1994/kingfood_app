package com.example.kingfood.presnter.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.example.kingfood.databinding.ActivitySplashBinding
import com.example.kingfood.presnter.MainActivity
import com.example.kingfood.presnter.auth.AuthActivity
import com.example.kingfood.utils.base.BaseActivity
import com.example.kingfood.utils.base.BaseActivityMVVM
import com.example.kingfood.utils.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import java.lang.Runnable

@AndroidEntryPoint
class SplashActivity : BaseActivityMVVM<ActivitySplashBinding, SplashViewModel>() {

    override fun getViewBinding(): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    private val handler by lazy { Handler(Looper.getMainLooper()) }
    private val runable by lazy {
        Runnable {

        }
    }

    override fun initOnCreate() {

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runable)

    }

    override fun getViewModelClass(): Class<out BaseViewModel> = SplashViewModel::class.java


    override fun initObservables() {
        MainScope().launch {
            delay(1200)
            val hasUser= getViewModel().getCurrentUser().value.isNullOrEmpty()

            if (hasUser)
                startActivity(Intent(this@SplashActivity, AuthActivity::class.java))
            else
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}