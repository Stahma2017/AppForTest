package com.stas.ui.blureffect.blureffectslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.stas.appfortest.databinding.ItemBlurSampleBinding

class BlurSamplesAdapter : RecyclerView.Adapter<BlurSamplesAdapter.ViewHolder>() {

  var items: List<BlurSampleItem> = listOf()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemBlurSampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(items[position])
  }

  override fun getItemCount() = items.size

  inner class ViewHolder(val binding: ItemBlurSampleBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BlurSampleItem) {
      binding.blurSampleTitle.text = item.title
      binding.blurSampleImage.setImageResource(item.resId)
    }
  }

  data class BlurSampleItem(val title: String, @DrawableRes val resId: Int)
}