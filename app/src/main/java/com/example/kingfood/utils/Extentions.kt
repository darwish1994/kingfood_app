package com.example.kingfood.utils

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))


fun ImageView.loadFrom(url: String?) {
    Glide.with(this)
        .load("http://34.135.157.26/storage/$url")
        .apply(RequestOptions.bitmapTransform( RoundedCorners(25)))
        .into(this)
}