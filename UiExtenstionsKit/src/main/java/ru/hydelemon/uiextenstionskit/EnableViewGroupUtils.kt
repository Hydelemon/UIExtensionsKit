package ru.hydelemon.uiextenstionskit

import android.view.View
import android.view.ViewGroup




class EnableViewGroupUtils {
    fun enableDisableView(view: View, enabled: Boolean) {
        view.isEnabled = enabled
        if (view is ViewGroup) {
            for (idx in 0 until view.childCount) {
                enableDisableView(view.getChildAt(idx), enabled)
            }
        }
    }
}