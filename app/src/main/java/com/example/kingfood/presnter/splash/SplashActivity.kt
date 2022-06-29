package com.example.kingfood.presnter.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.example.kingfood.databinding.ActivitySplashBinding
import com.example.kingfood.presnter.auth.AuthActivity
import com.example.kingfood.presnter.base.BaseActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun getViewBinding(): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    private val handler by lazy { Handler(Looper.getMainLooper()) }
    private val runable by lazy {
        Runnable {
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
    }

    override fun initOnCreate() {

        handler.postDelayed(runable, (1.3 * 1000).toLong())

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runable)

    }
}