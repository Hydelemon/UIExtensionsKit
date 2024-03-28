package ru.hydelemon.uiextensionskit

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

class KeyboardUtils {
    fun showSoftKeyboard(activity: Activity, view: View) {
        val inputMethodManager =
            activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
        if (activity.currentFocus != null) {
            inputMethodManager.showSoftInput(
                view,0
            )
        }
    }
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
        if (activity.currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken, 0
            )
        }
    }
}