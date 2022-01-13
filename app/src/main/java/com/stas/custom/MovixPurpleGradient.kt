package com.stas.custom

import android.content.Context
import androidx.core.content.ContextCompat
import com.stas.appfortest.R

class MovixPurpleGradient(context: Context) : BaseLinearGradient() {

  override val colors: IntArray = intArrayOf(
    ContextCompat.getColor(context, R.color.mauve),
    ContextCompat.getColor(context, R.color.navy_blue),
    ContextCompat.getColor(context, R.color.navy_blue),
    ContextCompat.getColor(context, R.color.persian_blue)
  )
  override val positions: FloatArray = floatArrayOf(0f, 0.366f, 0.6061f, 1f)
}