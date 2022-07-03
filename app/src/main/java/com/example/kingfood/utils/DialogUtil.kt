package com.example.kingfood.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import com.example.kingfood.databinding.DialogLoadingBinding

object DialogUtil {
    fun showLoading(
        context: Context,
        layout: DialogLoadingBinding

    ): AlertDialog {
        val alertDialog = AlertDialog.Builder(context).apply {
            setView(layout.root)
            setCancelable(false)
        }.create()

        alertDialog.apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        }
        return alertDialog
    }
}