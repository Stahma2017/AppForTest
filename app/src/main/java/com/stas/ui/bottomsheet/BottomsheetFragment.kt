package com.stas.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.stas.appfortest.DataHolder
import com.stas.appfortest.databinding.FragmentBottomsheetBinding
import com.stas.ui.base.BaseFragment

class BottomsheetFragment : BaseFragment<FragmentBottomsheetBinding>() {

  override fun provideViewBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): FragmentBottomsheetBinding = FragmentBottomsheetBinding.inflate(inflater, container, false)

  override fun prepareUi(savedInstanceState: Bundle?) {
    super.prepareUi(savedInstanceState)
    binding.sheetContent.text = DataHolder.lorem
  }
}