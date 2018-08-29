package com.adrian.circleprogressbarlib

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout

/**
 * date:2018/8/28 19:27
 * author：RanQing
 * description：此控件是为了方便开发者需要在有进度的按钮中加入自己的布局文件
 */
class FantasticButton : FrameLayout {

    //进度
    var mProgress = 0
        set(value) {
            field = value
            mCircleProgressBar?.mProgress = value
        }
    //进度条最大值
    var mMax = CircleProgressBar.DEFAULT_MAX
        set(value) {
            field = value
            mCircleProgressBar?.mMax = value
        }

    //仅表盘式进度条有用，表示表盘刻度数量
    var mLineCount = 0
        set(value) {
            field = value
            mCircleProgressBar?.mLineCount = value
        }
    //仅表盘式进度条有用，表示刻度线宽度
    var mLineWidth = 0f
        set(value) {
            field = value
            mCircleProgressBar?.mLineWidth = value
        }

    //进度条宽度
    var mProgressStrokeWidth = 0f
        set(value) {
            field = value
            mCircleProgressBar?.mProgressStrokeWidth = value
        }

    //进度条进度开始颜色
    var mProgressStartColor = Color.BLACK
        set(value) {
            field = value
            mCircleProgressBar?.mProgressStartColor = value
        }
    //进度条进度结束颜色
    var mProgressEndColor = Color.BLACK
        set(value) {
            field = value
            mCircleProgressBar?.mProgressEndColor = value
        }

    //进度条背景色
    var mProgressBackgroundColor = Color.WHITE
        set(value) {
            field = value
            mCircleProgressBar?.mProgressBackgroundColor = value
        }

    //控件中间填充色（仅表盘式及线形进度有效，扇形未填充）
    var mCenterColor: Int = Color.TRANSPARENT
        set(value) {
            field = value
            mCircleProgressBar?.mCenterColor = value
        }

    //进度条旋转起始角度.默认-90
    var mStartDegree = -90f
        set(value) {
            field = value
            mCircleProgressBar?.mStartDegree = value
        }
    //是否只在进度条之外绘制背景色
    var mDrawBackgroundOutsideProgress = false
        set(value) {
            field = value
            mCircleProgressBar?.mDrawBackgroundOutsideProgress = value
        }

    //停止动画类型
    @CircleProgressBar.StopAnimType
    var mStopAnimType = 0
        set(value) {
            field = value
            mCircleProgressBar?.mStopAnimType = value
        }

    //进度条颜色样式
    @CircleProgressBar.Style
    var mStyle = CircleProgressBar.LINE
        set(value) {
            field = value
            mCircleProgressBar?.mStyle = value
        }

    //画笔着色器
    @CircleProgressBar.ShaderMode
    var mShader = CircleProgressBar.LINEAR
        set(value) {
            field = value
            mCircleProgressBar?.mShader = value
        }
    //进度及背景画笔绘制两端形状.Cap.ROUND(圆形线帽)、Cap.SQUARE(方形线帽)、Paint.Cap.BUTT(无线帽)
    var mCap: Paint.Cap = Paint.Cap.BUTT
        set(value) {
            field = value
            mCircleProgressBar?.mCap = value
        }

    private var mCircleProgressBar: CircleProgressBar? = null

    var mOnPressedListener: CircleProgressBar.OnPressedListener? = null
        set(value) {
            field = value
            mCircleProgressBar?.mOnPressedListener = value
        }

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mCircleProgressBar = CircleProgressBar(context)
        mCircleProgressBar?.mShowValue = false
        super.addView(mCircleProgressBar)

        foregroundGravity = Gravity.CENTER
    }

    /**
     * 设置居中子控件
     */
    fun setCenterView(child: View?) {
        removeAllViews()
        addView(mCircleProgressBar)
        super.addView(child)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev == null) return true

        when(ev.action) {
            MotionEvent.ACTION_DOWN -> {
                mCircleProgressBar?.startAnimator()
            }
            MotionEvent.ACTION_UP -> {
                mCircleProgressBar?.stopAnimator()
            }
            MotionEvent.ACTION_CANCEL -> {
                mCircleProgressBar?.stopAnimator()
            }
        }
        return super.dispatchTouchEvent(ev)
    }

}