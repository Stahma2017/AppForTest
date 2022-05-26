package com.stas.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.stas.appfortest.DataHolder
import com.stas.appfortest.databinding.FragmentBottomsheetBinding
import com.stas.ui.base.BaseFragment

class BottomsheetFragment : BaseFragment<FragmentBottomsheetBinding>() {
  private lateinit var bottomsheetBehavior: BottomSheetBehavior<ConstraintLayout>

  override fun provideViewBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): FragmentBottomsheetBinding = FragmentBottomsheetBinding.inflate(inflater, container, false)

  override fun prepareUi(savedInstanceState: Bundle?) {
    bottomsheetBehavior = BottomSheetBehavior.from(binding.sheetContainer)
    binding.sheetContent.text = DataHolder.lorem

    binding.sheetExpand.setOnClickListener {
      bottomsheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }
  }
}