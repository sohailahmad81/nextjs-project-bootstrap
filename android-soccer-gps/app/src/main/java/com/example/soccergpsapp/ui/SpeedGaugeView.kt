package com.example.soccergpsapp.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class SpeedGaugeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectF = RectF()
    private var speedPercent: Float = 0f // 0 to 1

    fun setSpeedPercent(percent: Float) {
        speedPercent = percent.coerceIn(0f, 1f)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()
        val radius = min(width, height) / 2 * 0.8f
        val centerX = width / 2
        val centerY = height / 2

        rectF.set(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius
        )

        // Draw background arc
        paint.color = Color.LTGRAY
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 30f
        canvas.drawArc(rectF, 135f, 270f, false, paint)

        // Draw progress arc
        paint.color = Color.BLUE
        paint.strokeWidth = 30f
        val sweepAngle = 270f * speedPercent
        canvas.drawArc(rectF, 135f, sweepAngle, false, paint)

        // Draw speed text
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = radius / 2
        paint.textAlign = Paint.Align.CENTER
        val speedValue = (speedPercent * 100).toInt()
        canvas.drawText("$speedValue km/h", centerX, centerY + radius / 4, paint)
    }
}
