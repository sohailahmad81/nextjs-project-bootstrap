package com.example.soccergpsapp.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class HeatmapView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val heatmapPoints = mutableListOf<PointF>()

    fun setHeatmapPoints(points: List<PointF>) {
        heatmapPoints.clear()
        heatmapPoints.addAll(points)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw soccer field background (green)
        paint.color = Color.parseColor("#228B22")
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        // Draw heatmap points as red circles with alpha
        paint.color = Color.RED
        paint.alpha = 100
        for (point in heatmapPoints) {
            val x = point.x * width
            val y = point.y * height
            canvas.drawCircle(x, y, 30f, paint)
        }
    }
}
