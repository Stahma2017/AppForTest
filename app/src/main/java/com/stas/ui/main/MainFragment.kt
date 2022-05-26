package com.stas.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stas.appfortest.DataHolder
import com.stas.appfortest.databinding.FragmentMainBinding
import com.stas.ui.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {

  override fun provideViewBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): FragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)

  override fun prepareUi(savedInstanceState: Bundle?) {
    setupSamples()
  }

  private val adapter: SamplesAdapter = SamplesAdapter { sampleType ->
    (activity as MainActivity).navigateTo(sampleType)
  }

  private fun setupSamples() {
    binding.samples.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    binding.samples.adapter = adapter
    binding.samples.addItemDecoration(VerticalItemDecoration(20))
    adapter.items = DataHolder.samples
  }

}