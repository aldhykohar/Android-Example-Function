package com.aldhykohar.androidexamplefunction.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aldhykohar.androidexamplefunction.databinding.ActivityMainBinding
import com.aldhykohar.androidexamplefunction.utils.CommonUtils.showToast

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClick()
    }

    private fun initClick() {
        with(binding) {
            mbToast.setOnClickListener { showToast("This is Custom Toast") }
            mbPermission.setOnClickListener { }
        }
    }


}