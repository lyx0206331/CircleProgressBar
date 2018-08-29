package com.adrian.circleprogressbarlib

import android.content.Context
import android.util.Log

/**
 * date:2018/8/27 16:57
 * author：RanQing
 * description：
 */
object Utils {

    fun dip2px(context: Context, dpValue: Float): Float {
        val scale = context.resources.displayMetrics.density
        return dpValue * scale + .5f
    }

    fun logE(tag: String, msg: String?) {
        Log.e(tag, msg ?: "unknown error")
    }
}