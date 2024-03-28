package ru.hydelemon.uiextensionskit

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import android.view.View
import androidx.window.layout.WindowMetricsCalculator
import kotlin.math.ceil

class ScreenUtils {
    fun dpToPx(dp: Float, context: Context): Int {
        return if (dp == 0f) {
            0
        } else {
            val density = context.resources.displayMetrics.density
            ceil((density * dp).toDouble()).toInt()
        }
    }

    fun pxToDp(px: Float, context: Context): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            px,
            context.resources.displayMetrics
        )
    }

    fun getWidthOfScreen(activity: Activity): Int {
        val windowMetrics =
            WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(activity)
        val currentBounds = windowMetrics.bounds // E.g. [0 0 1350 1800]
        val width = currentBounds.width()
        return width
    }

    fun getHeightOfScreen(activity: Activity): Int {
        val windowMetrics =
            WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(activity)
        val currentBounds = windowMetrics.bounds // E.g. [0 0 1350 1800]
        val height = currentBounds.height()
        return height
    }

    fun getLocationOfView(
        activity: Activity,
        anchor: View,
    ): IntArray {
        val anchorLocation = IntArray(2)
        anchor.getLocationInWindow(anchorLocation)
        val anchorX = anchorLocation[0]
        val anchorY = anchorLocation[1]

        val windowWidth = getWidthOfScreen(activity)
        val windowHeight = getHeightOfScreen(activity)

        val xLocation = windowWidth - anchorX
        val yLocation = windowHeight - anchorY

        val location = IntArray(2)
        location[0] = xLocation
        location[1] = yLocation
        return location
    }
}