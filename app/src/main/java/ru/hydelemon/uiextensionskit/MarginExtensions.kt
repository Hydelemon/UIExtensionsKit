package ru.hydelemon.uiextensionskit

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup

class MarginExtensions {
    fun View.margin(
        left: Float? = null,
        top: Float? = null,
        right: Float? = null,
        bottom: Float? = null,
    ) {
        layoutParams<ViewGroup.MarginLayoutParams> {
            left?.run { leftMargin = dpToPx(this) }
            top?.run { topMargin = dpToPx(this) }
            right?.run { rightMargin = dpToPx(this) }
            bottom?.run { bottomMargin = dpToPx(this) }
        }
    }

    fun View.marginInPixels(
        left: Int? = null,
        top: Int? = null,
        right: Int? = null,
        bottom: Int? = null,
    ) {
        layoutParams<ViewGroup.MarginLayoutParams> {
            left?.run { leftMargin = left }
            top?.run { topMargin = top }
            right?.run { rightMargin = right }
            bottom?.run { bottomMargin = bottom }
        }
    }

    inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
        if (layoutParams is T) block(layoutParams as T)
    }

    fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
    fun Context.dpToPx(dp: Float): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()
}