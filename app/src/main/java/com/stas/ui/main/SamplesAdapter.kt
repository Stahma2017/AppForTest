package com.stas.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stas.appfortest.databinding.ItemSampleBinding

class SamplesAdapter(val sampleClick: (MainActivity.Screen) -> Unit) :
  RecyclerView.Adapter<SamplesAdapter.ViewHolder>() {

  var items: List<SampleItem> = listOf()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemSampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(items[position])
  }

  override fun getItemCount() = items.size

  inner class ViewHolder(val binding: ItemSampleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: SampleItem) {
      binding.sampleTitle.text = item.title
      itemView.setOnClickListener { sampleClick(item.sampleType) }
    }
  }

  data class SampleItem(val title: String, val sampleType: MainActivity.Screen)
}