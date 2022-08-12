package com.stas.ui.bottomsheetmodal

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.stas.appfortest.R
import com.stas.appfortest.databinding.FragmentBottomsheetModalBinding
import com.stas.ui.base.BaseBottomSheetDialogFragment

class BottomsheetModalFragment : BaseBottomSheetDialogFragment<FragmentBottomsheetModalBinding>() {

  lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val dialog = super.onCreateDialog(savedInstanceState)
    //setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.ModalBottomSheetStyle)
    bottomSheetBehavior = (dialog as BottomSheetDialog).behavior
    return dialog
  }

  override fun provideViewBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): FragmentBottomsheetModalBinding =
    FragmentBottomsheetModalBinding.inflate(inflater, container, false)


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    //bottomSheetBehavior.disableShapeAnimations()
    bottomSheetBehavior.isFitToContents = true
    bottomSheetBehavior.skipCollapsed = true
  }
}