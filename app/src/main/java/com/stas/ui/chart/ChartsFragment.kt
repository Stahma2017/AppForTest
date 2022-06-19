package com.stas.ui.chart

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.stas.appfortest.databinding.FragmentChartsBinding
import com.stas.ui.base.BaseFragment

class ChartsFragment : BaseFragment<FragmentChartsBinding>() {

  override fun provideViewBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): FragmentChartsBinding = FragmentChartsBinding.inflate(inflater, container, false)

  override fun prepareUi(savedInstanceState: Bundle?) {

    val lineData = LineData(LineDataSet(listOf(Entry(0f, 1f), Entry(2f, 4f), Entry(3f, 6f), Entry(6f, 2f)), "Some label"))
    lineData.setDrawValues(false)
    // lineData.isHighlightEnabled = false

    binding.lineChart.setBackgroundColor(Color.rgb(255, 255, 255))
    binding.lineChart.setDrawGridBackground(false)

    val axis = binding.lineChart.xAxis
    axis.setDrawGridLines(false)



    binding.lineChart.data = lineData
    binding.lineChart.invalidate()
  }

}