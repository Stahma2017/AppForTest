package com.stas.ui.main

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class VerticalItemDecoration(val offset: Int) : RecyclerView.ItemDecoration() {

  override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
    val isLastItem = itemPosition == parent.adapter!!.itemCount - 1
    val isFirstItem = itemPosition == 0
    outRect.top = if (isFirstItem) offset else offset / 2
    outRect.bottom = if (isLastItem) offset else offset / 2
  }
}