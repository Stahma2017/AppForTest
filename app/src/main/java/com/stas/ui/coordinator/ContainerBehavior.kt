package com.stas.ui.coordinator

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContainerBehavior() : AppBarLayout.ScrollingViewBehavior() {
  constructor(context: Context, attributeSet: AttributeSet) : this()

  override fun onMeasureChild(
    parent: CoordinatorLayout,
    child: View,
    parentWidthMeasureSpec: Int,
    widthUsed: Int,
    parentHeightMeasureSpec: Int,
    heightUsed: Int
  ): Boolean {

    // if child is not scrolling measure it manually
    if (child is FragmentContainerView && !child.children.first().isNestedScrollingEnabled) {
      val appbar = parent.children.find { it is AppBarLayout }
      val ah = appbar?.measuredHeight ?: 0
      val bottombar = parent.children.find { it is BottomNavigationView }
      val bh = if (bottombar?.isVisible == true) bottombar.measuredHeight else 0
      val height = View.MeasureSpec.getSize(parentHeightMeasureSpec) - ah - bh

      parent.onMeasureChild(
        child,
        parentWidthMeasureSpec,
        widthUsed,
        View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY),
        heightUsed
      )

      return true
    }

    // if child is scrolling measure parent
    return super.onMeasureChild(
      parent,
      child,
      parentWidthMeasureSpec,
      widthUsed,
      parentHeightMeasureSpec,
      heightUsed
    )
  }

  override fun onStartNestedScroll(
    coordinatorLayout: CoordinatorLayout,
    child: View,
    directTargetChild: View,
    target: View,
    axes: Int,
    type: Int
  ): Boolean {
    return true
    return super.onStartNestedScroll(
      coordinatorLayout,
      child,
      directTargetChild,
      target,
      axes,
      type
    )
  }

  override fun onNestedPreFling(
    coordinatorLayout: CoordinatorLayout,
    child: View,
    target: View,
    velocityX: Float,
    velocityY: Float
  ): Boolean {
    Log.d("TEST32", "onNestedPreFling()")
    return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)
  }

  override fun onNestedPreScroll(
    coordinatorLayout: CoordinatorLayout,
    child: View,
    target: View,
    dx: Int,
    dy: Int,
    consumed: IntArray,
    type: Int
  ) {
    Log.d("TEST32", "onNestedPreScroll()")
    super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
  }

  override fun onNestedScroll(
    coordinatorLayout: CoordinatorLayout,
    child: View,
    target: View,
    dxConsumed: Int,
    dyConsumed: Int,
    dxUnconsumed: Int,
    dyUnconsumed: Int,
    type: Int,
    consumed: IntArray
  ) {
    Log.d("TEST32", "onNestedScroll()")
    super.onNestedScroll(
      coordinatorLayout,
      child,
      target,
      dxConsumed,
      dyConsumed,
      dxUnconsumed,
      dyUnconsumed,
      type,
      consumed
    )
  }
}