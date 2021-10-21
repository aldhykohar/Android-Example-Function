package com.aldhykohar.androidexamplefunction.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldhykohar.androidexamplefunction.R
import com.aldhykohar.androidexamplefunction.databinding.ActivityTabLayoutBinding
import com.aldhykohar.androidexamplefunction.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {
    private val binding: ActivityTabLayoutBinding by lazy {
        ActivityTabLayoutBinding.inflate(layoutInflater)
    }

    val images = listOf(
        R.drawable.ps4_console_white_1,
        R.drawable.ps4_console_white_2,
        R.drawable.ps4_console_white_3,
        R.drawable.ps4_console_white_4,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val adapter = ViewPagerAdapter(images)
        with(binding) {
            viewPager.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = "Tab ${position + 1}"
            }.attach()

        }


    }
}