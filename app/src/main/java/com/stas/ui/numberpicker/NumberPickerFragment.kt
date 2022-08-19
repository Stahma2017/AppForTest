package com.stas.ui.numberpicker

import android.app.Dialog
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.stas.appfortest.databinding.FragmentNumberPickerBinding
import com.stas.ui.base.BaseBottomSheetDialogFragment

class NumberPickerFragment : BaseBottomSheetDialogFragment<FragmentNumberPickerBinding>() {

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
    ): FragmentNumberPickerBinding =
        FragmentNumberPickerBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetBehavior.isFitToContents = true
        bottomSheetBehavior.skipCollapsed = true


        val values = arrayOf("1.0", "1.2", "1.3", "1.4", "2.0", "2.3", "2.6", "2.7")

        binding.numberPicker.textColor = Color.parseColor("#C7C7CC")
        binding.numberPicker.textSize = 54f
        binding.numberPicker.wrapSelectorWheel = false
        binding.numberPicker.selectionDividerHeight = 1.dpToPx()
        binding.numberPicker.minValue = 0
        binding.numberPicker.maxValue = values.size  - 1
        binding.numberPicker.displayedValues = values
        binding.numberPicker.setOnValueChangedListener { numberPicker, oldValue, newValue ->
            Log.d("TEST8", "value is $newValue")
        }
    }
}

fun Int.dpToPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()