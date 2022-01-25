package com.stas

import android.graphics.PointF
import android.view.View
import android.widget.ImageView
import android.widget.TextView

inline fun Pair<PointF?, PointF?>.runIfElementsNotNull(block: (PointF, PointF) -> Unit) {
  val firstCopy = first
  val secondCopy = second
  if (firstCopy != null && secondCopy != null) {
    block(firstCopy, secondCopy)
  }
}

fun View.toggleVisibility(visible: Boolean, visibilityWhenFalse: Int = View.GONE) =
  run { visibility = if (visible) View.VISIBLE else visibilityWhenFalse }

fun ImageView.toggleVisibilityIfHasContent(visibilityWhenFalse: Int = View.GONE) {
  visibility = if (drawable != null) View.VISIBLE else visibilityWhenFalse
}

fun TextView.toggleVisibilityIfHasContent(visibilityWhenFalse: Int = View.GONE) {
  visibility = if (!text.isNullOrEmpty()) View.VISIBLE else visibilityWhenFalse
}