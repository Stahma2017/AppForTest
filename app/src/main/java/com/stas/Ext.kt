package com.stas

import android.graphics.PointF
import android.view.View

inline fun Pair<PointF?, PointF?>.runIfElementsNotNull(block: (PointF, PointF) -> Unit) {
  val firstCopy = first
  val secondCopy = second
  if (firstCopy != null && secondCopy != null) {
    block(firstCopy, secondCopy)
  }
}

fun View.toggleVisibility(visible: Boolean, visibilityWhenFalse: Int = View.GONE) =
  run { visibility = if (visible) View.VISIBLE else visibilityWhenFalse }