package com.stas.custom.textfield

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.movix.android.uikit.textfield.Mode
import com.stas.appfortest.R
import com.stas.custom.GradientUtils
import com.stas.custom.MovixPurpleGradient
import com.stas.runIfElementsNotNull
import kotlin.properties.Delegates

internal class TextFieldBorderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var mode: Mode by Delegates.observable(Mode.Empty) { _, _, _ -> invalidate() }

    private val borderDrawer = BorderDrawer()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        borderDrawer.onDraw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        borderDrawer.onSizeChanged(w, h)
    }

    inner class BorderDrawer {

        private val borderWidth =
            context.resources.getDimension(R.dimen.text_field_border_stroke_width)

        private val cornerRadius = resources.getDimension(R.dimen.text_field_border_corner_radius)

        private val movixPurpleGradient = MovixPurpleGradient(context)

        private val borderRect = RectF()

        private val emptyPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
            color = ContextCompat.getColor(context, R.color.malibu)
        }

        private val errorPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
            color = ContextCompat.getColor(context, R.color.movix_red)
        }

        private val editPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
        }

        fun onDraw(canvas: Canvas) {
            val paint = when (mode) {
                Mode.Empty -> emptyPaint
                Mode.Edit -> editPaint
                Mode.Fill -> emptyPaint
                Mode.Error -> errorPaint
            }
            canvas.drawRoundRect(borderRect, cornerRadius, cornerRadius, paint)
        }

        fun onSizeChanged(w: Int, h: Int) {
            val halfStrokeWidth = borderWidth / 2
            borderRect.set(
                halfStrokeWidth,
                halfStrokeWidth,
                w.toFloat() - halfStrokeWidth,
                h.toFloat() - halfStrokeWidth
            )

            GradientUtils.pointsForGradient(
                PointF(borderRect.left + borderRect.width() * 0.45f, borderRect.top),
                PointF(borderRect.left + borderRect.width() * 0.55f, borderRect.bottom),
                borderRect
            ).runIfElementsNotNull { firstPoint, secondPoint ->
                editPaint.shader = LinearGradient(
                    firstPoint.x,
                    firstPoint.y,
                    secondPoint.x,
                    secondPoint.y,
                    movixPurpleGradient.colors,
                    movixPurpleGradient.positions,
                    Shader.TileMode.CLAMP
                )
            }
        }
    }
}