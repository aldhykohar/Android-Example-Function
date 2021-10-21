package com.aldhykohar.androidexamplefunction.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.androidexamplefunction.databinding.ItemViewPagerBinding


/**
 * Created by aldhykohar on 10/21/2021.
 */
class ViewPagerAdapter(val images: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.ViewPagerViewHolder {
        val binding =
            ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.ViewPagerViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size


    inner class ViewPagerViewHolder(private val binding: ItemViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imagerResource: Int) {
            binding.ivImage.setImageResource(imagerResource)
        }
    }
}