package ru.hydelemon.uiextensionskit

import android.view.View

class VisibilityExtensions {
    fun View?.gone() {
        this?.visibility = View.GONE
    }

    fun View?.visible() {
        this?.visibility = View.VISIBLE
    }

    fun View?.invisible() {
        this?.visibility = View.INVISIBLE
    }

    fun View.isVisible(): Boolean {
        return visibility == View.VISIBLE
    }

    fun View.isGone(): Boolean {
        return visibility == View.GONE
    }

    fun View.toggleVisibility(isShow: Boolean) {
        if (isShow) visible() else gone()
    }

    fun View.toggleInvisibility(isShow: Boolean) {
        if (isShow) visible() else invisible()
    }

    fun View?.toggleFieldVisibility(value: String?) {
        this?.toggleVisibility(!value.isNullOrEmpty())
    }

    fun View?.toggleFieldInVisibility(value: String?) {
        this?.toggleInvisibility(!value.isNullOrEmpty())
    }
}
