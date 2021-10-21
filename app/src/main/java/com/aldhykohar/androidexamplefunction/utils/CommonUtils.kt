package com.aldhykohar.androidexamplefunction.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.aldhykohar.androidexamplefunction.databinding.CustomToastBinding


/**
 * Created by aldhykohar on 10/21/2021.
 */
object CommonUtils {

    fun Context.showToast(msg: String) {
        Toast(this).apply {
            val toastBinding = CustomToastBinding.inflate(LayoutInflater.from(this@showToast))
            toastBinding.tvMessage.text = msg

            duration = Toast.LENGTH_SHORT
            view = toastBinding.root
            show()
        }
    }
}