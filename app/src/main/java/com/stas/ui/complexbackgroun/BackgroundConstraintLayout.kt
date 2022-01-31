package com.stas.ui.complexbackgroun

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.stas.appfortest.R

class BackgroundConstraintLayout @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

  val paint = Paint();

  init {
    setWillNotDraw(false)
    paint.isAntiAlias = true
    paint.color = ContextCompat.getColor(context, R.color.movix_ocean);
  }


  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    Log.d("TEST43", "onMeasure()")
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
  }

  override fun onDraw(canvas: Canvas) {
    Log.d("TEST43", "onDraw()")
    canvas.drawRect(0f, 0f, 400f, 700f, paint)
    super.onDraw(canvas)
  }
}