package com.stas.custom

import android.graphics.*
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

object GradientUtils {
  fun pointsForGradient(
    pointLeft: PointF,
    pointRight: PointF,
    rect: Rect
  ): Pair<PointF?, PointF?> = pointsForGradient(pointLeft, pointRight, RectF(rect))

  fun pointsForGradient(
    pointLeft: PointF,
    pointRight: PointF,
    rect: RectF
  ): Pair<PointF?, PointF?> {
    val gradientMiddleLine =
      Line(PointF(pointLeft.x, pointLeft.y), PointF(pointRight.x, pointRight.y))

    val perpendicular0 = gradientMiddleLine.perpendicular(gradientMiddleLine.center())

    val rectTopLine = Line(PointF(rect.left, rect.top), PointF(rect.right, rect.top))

    val _angle = perpendicular0.angleBetween(rectTopLine)
    val angle = if (_angle < 0) _angle + 180 else _angle

    require(angle in 0f..180f) { "Angle must bee between 0 and 180 degrees" }

    val points = when (angle) {
      in 90f..180f -> Pair(PointF(rect.left, rect.top), PointF(rect.right, rect.bottom))
      in 0f..90f -> Pair(PointF(rect.right, rect.top), PointF(rect.left, rect.bottom))
      else -> throw RuntimeException("Angle must bee between 0 and 360 degrees")
    }

    val perpendicular1 = perpendicular0.perpendicular(points.first)
    val perpendicular2 = perpendicular0.perpendicular(points.second)

    return Pair(
      perpendicular0.intersect(perpendicular1),
      perpendicular0.intersect(perpendicular2)
    )
  }

  fun calculateAppearanceRect(
    appearance: Float,
    mainRect: RectF,
    appearanceRect: RectF
  ): Pair<RectF, Float>? {
    appearanceRect.set(
      mainRect.left + mainRect.width() * appearance,
      mainRect.top + mainRect.height() * appearance,
      mainRect.right + mainRect.width() * appearance,
      mainRect.bottom + mainRect.height() * appearance
    )
    val line1 = Line(
      PointF(appearanceRect.left, appearanceRect.top),
      PointF(appearanceRect.right, appearanceRect.bottom)
    )
    val perpendicular1 =
      line1.perpendicular(PointF(appearanceRect.left, appearanceRect.top))
    val perpendicular2 =
      line1.perpendicular(PointF(appearanceRect.right, appearanceRect.bottom))

    val perpendicular3 = perpendicular1.perpendicular(
      PointF(
        appearanceRect.left,
        appearanceRect.bottom
      )
    )
    val perpendicular4 = perpendicular2.perpendicular(
      PointF(
        appearanceRect.right,
        appearanceRect.top
      )
    )

    val point1 = perpendicular1.intersect(perpendicular3)
    val point2 = perpendicular2.intersect(perpendicular4)

    if (point1 != null && point2 != null) {
      val l1 = Line(
        PointF(point1.x, point1.y),
        PointF(appearanceRect.left, appearanceRect.top)
      )
      val l2 = Line(
        PointF(
          appearanceRect.right,
          appearanceRect.bottom
        ),
        PointF(point2.x, point2.y)
      )

      val l3 = Line(
        PointF(appearanceRect.left, appearanceRect.top),
        PointF(appearanceRect.left, appearanceRect.bottom)
      )

      val rectRotateAngle = l1.angleBetween(l3).toFloat()

      l1.rotate(
        rectRotateAngle,
        PointF(appearanceRect.centerX(), appearanceRect.centerY())
      )
      l2.rotate(
        rectRotateAngle,
        PointF(appearanceRect.centerX(), appearanceRect.centerY())
      )

      val p1 = PointF(l1.a.x, l1.a.y)
      val p2 = PointF(l2.b.x, l2.b.y)

      appearanceRect.set(p1.x, p1.y, p2.x, p2.y)
      return Pair(appearanceRect, rectRotateAngle)
    }
    return null
  }

  fun calculateSquirclePath(
    path: Path,
    scaleMatrix: Matrix,
    rectF: RectF,
    width: Float,
    height: Float,
    borderWidth: Float
  ) {
    path.rewind()
    path.moveTo(97.7f, 15.7f)
    path.cubicTo(97.1f, 12.6f, 96f, 9.9f, 94.4f, 7.7f)
    path.cubicTo(92.7f, 5.4f, 90.7f, 3.8f, 88.5f, 3f)
    path.cubicTo(80.5f, 0f, 49.9f, 0f, 49.9f, 0f)
    path.cubicTo(49.9f, 0f, 19.4f, 0.1f, 11.4f, 3.1f)
    path.cubicTo(9.2f, 3.9f, 7.2f, 5.5f, 5.5f, 7.7f)
    path.cubicTo(3.9f, 10f, 2.8f, 12.7f, 2.2f, 15.8f)
    path.cubicTo(-0.3f, 35.4f, -1.2f, 65.4f, 2.2f, 84.3f)
    path.cubicTo(2.8f, 87.4f, 4f, 90.1f, 5.6f, 92.3f)
    path.cubicTo(7.2f, 94.6f, 9.2f, 96.2f, 11.4f, 97f)
    path.cubicTo(19.5f, 100f, 50f, 100f, 50f, 100f)
    path.cubicTo(50f, 100f, 80.6f, 100f, 88.6f, 97f)
    path.cubicTo(90.8f, 96.2f, 92.8f, 94.6f, 94.4f, 92.3f)
    path.cubicTo(96f, 90.1f, 97.2f, 87.4f, 97.8f, 84.3f)
    path.cubicTo(100.3f, 64.6f, 101.1f, 34.6f, 97.7f, 15.7f)
    path.close()

    path.computeBounds(rectF, true)
    path.offset(width / 2f - rectF.width() / 2f, height / 2f - rectF.height() / 2f)
    path.computeBounds(rectF, true)
    scaleMatrix.setScale(
      (width - borderWidth) / 100f,
      (height - borderWidth) / 100f,
      rectF.centerX(),
      rectF.centerY()
    )
    path.transform(scaleMatrix)
  }

  data class Line(val a: PointF, val b: PointF) {

    fun intersect(line: Line): PointF? {
      // Line AB represented as a1x + b1y = c1
      val a1 = this.b.y - this.a.y
      val b1 = this.a.x - this.b.x
      val c1 = a1 * this.a.x + b1 * this.a.y

      // Line CD represented as a2x + b2y = c2
      val a2 = line.b.y - line.a.y
      val b2 = line.a.x - line.b.x
      val c2 = a2 * line.a.x + b2 * line.a.y

      val determinant = a1 * b2 - a2 * b1

      return if (determinant == 0f) {
        // The lines are parallel
        null
      } else {
        val x = (b2 * c1 - b1 * c2) / determinant
        val y = (a1 * c2 - a2 * c1) / determinant
        PointF(x, y)
      }
    }

    fun rotate(angle: Float) {
      val cx = (a.x + b.x) * 0.5f
      val cy = (a.y + b.y) * 0.5f

      val sinA = sin(Math.toRadians(angle.toDouble())).toFloat()
      val cosA = cos(Math.toRadians(angle.toDouble())).toFloat()

      val tempAx: Float = a.x - cx
      val tempAy: Float = a.y - cy
      val aX = tempAx * cosA - tempAy * sinA + cx
      val aY = tempAx * sinA + tempAy * cosA + cy

      val tempBx: Float = b.x - cx
      val tempBy: Float = b.y - cy
      val bX = tempBx * cosA - tempBy * sinA + cx
      val bY = tempBx * sinA + tempBy * cosA + cy

      a.set(aX, aY)
      b.set(bX, bY)
    }

    fun rotate(angle: Float, point: PointF) {
      val cx = point.x
      val cy = point.y

      val sinA = sin(Math.toRadians(angle.toDouble())).toFloat()
      val cosA = cos(Math.toRadians(angle.toDouble())).toFloat()

      val tempAx: Float = a.x - cx
      val tempAy: Float = a.y - cy
      val aX = tempAx * cosA - tempAy * sinA + cx
      val aY = tempAx * sinA + tempAy * cosA + cy

      val tempBx: Float = b.x - cx
      val tempBy: Float = b.y - cy
      val bX = tempBx * cosA - tempBy * sinA + cx
      val bY = tempBx * sinA + tempBy * cosA + cy

      a.set(aX, aY)
      b.set(bX, bY)
    }

    fun perpendicular(fromPoint: PointF): Line {
      val dx = a.x - b.x
      val dy = a.y - b.y

      val ox = fromPoint.x
      val oy = fromPoint.y

      return Line(PointF(ox, oy), PointF(ox + dy, oy - dx))
    }

    fun angleBetween(line: Line): Double {
      val angle1 = atan2(
        (this.b.y - this.a.y).toDouble(),
        (this.a.x - this.b.x).toDouble()
      )
      val angle2 = atan2(
        (line.b.y - line.a.y).toDouble(),
        (line.a.x - line.b.x).toDouble()
      )

      return Math.toDegrees(angle1 - angle2)
    }

    fun center(): PointF = PointF((this.a.x + this.b.x) * 0.5f, (this.a.y + this.b.y) * 0.5f)
  }
}