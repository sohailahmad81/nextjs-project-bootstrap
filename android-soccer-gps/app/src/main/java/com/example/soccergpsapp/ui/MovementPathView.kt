package com.example.soccergpsapp.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MovementPathView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = Color.RED
        strokeWidth = 5f
        style = Paint.Style.STROKE
        isAntiAlias = true
    }

    private val path = Path()
    private val points = mutableListOf<PointF>()

    fun setMovementPoints(movementPoints: List<PointF>) {
        points.clear()
        points.addAll(movementPoints)
        buildPath()
        invalidate()
    }

    private fun buildPath() {
        path.reset()
        if (points.isNotEmpty()) {
            val first = points[0]
            path.moveTo(first.x * width, first.y * height)
            for (i in 1 until points.size) {
                val p = points[i]
                path.lineTo(p.x * width, p.y * height)
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Draw soccer field background (green)
        val paintBg = Paint()
        paintBg.color = Color.parseColor("#228B22")
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paintBg)

        // Draw movement path
        canvas.drawPath(path, paint)
    }
}
