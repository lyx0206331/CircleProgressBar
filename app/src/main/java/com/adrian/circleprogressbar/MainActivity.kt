package com.adrian.circleprogressbar

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.Button
import android.widget.Toast
import com.adrian.circleprogressbarlib.CircleProgressBar
import com.adrian.circleprogressbarlib.Utils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_center_view.*

class MainActivity : AppCompatActivity() {

    private var mLineProgressBar: CircleProgressBar? = null
    private var mSolidProgressBar: CircleProgressBar? = null
    private var mCustomProgressBar1: CircleProgressBar? = null
    private var mCustomProgressBar2: CircleProgressBar? = null
    private var mCustomProgressBar3: CircleProgressBar? = null
    private var mCustomProgressBar4: CircleProgressBar? = null
    private var mCustomProgressBar5: CircleProgressBar? = null
    private var mCustomProgressBar6: CircleProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLineProgressBar = findViewById(R.id.line_progress)
        mSolidProgressBar = findViewById(R.id.solid_progress)
        mCustomProgressBar1 = findViewById(R.id.custom_progress1)
        mCustomProgressBar2 = findViewById(R.id.custom_progress2)
        mCustomProgressBar3 = findViewById(R.id.custom_progress3)
        mCustomProgressBar4 = findViewById(R.id.custom_progress4)
        mCustomProgressBar5 = findViewById(R.id.custom_progress5)
        mCustomProgressBar6 = findViewById(R.id.custom_progress6)

        mCustomProgressBar1?.mProgressTextSize = Utils.dip2px(this,10f)

        mCustomProgressBar5?.mProgressFormatter = object : CircleProgressBar.ProgressFormatter {
            override fun format(progress: Int, max: Int): CharSequence {
                return "${progress}s"
            }

        }

        fantastic_btn.mStyle = CircleProgressBar.SOLID_LINE
        fantastic_btn.mProgressStrokeWidth = Utils.dip2px(this, 3f)
        fantastic_btn.mProgressBackgroundColor = ContextCompat.getColor(this, R.color.holo_purple)
        fantastic_btn.mStopAnimType = CircleProgressBar.STOP_ANIM_REVERSE
        fantastic_btn.mCenterColor = ContextCompat.getColor(this, R.color.holo_blue_light)
        fantastic_btn.mProgressStartColor = ContextCompat.getColor(this, R.color.colorAccent)
        fantastic_btn.mProgressEndColor = ContextCompat.getColor(this, R.color.holo_orange_light)
        fantastic_btn.mShader = CircleProgressBar.LINEAR

        fantastic_btn.mOnPressedListener = object : CircleProgressBar.OnPressedListener {
            override fun onPressEnd() {
                toast("press end")
            }

            override fun onPressStart() {
                toast("press start")
            }

            override fun onPressProcess(progress: Int) {
                Utils.logE("PROGRESS", "progress: $progress")
//                btn.text = "btn:$progress"
                textView.text = "tv:$progress"
            }

            override fun onPressInterrupt(progress: Int) {
                toast("press interrupt: $progress")
            }
        }

        val centerView = LayoutInflater.from(this).inflate(R.layout.layout_center_view, null)
        centerView.findViewById<Button>(R.id.btn).setOnTouchListener { view, motionEvent ->
            when(motionEvent.action) {
                MotionEvent.ACTION_DOWN -> (view as Button).text = "Down"
                MotionEvent.ACTION_UP -> (view as Button).text = "Up"
            }
            super.onTouchEvent(motionEvent)
        }
        fantastic_btn.setCenterView(centerView)
    }

    override fun onResume() {
        super.onResume()
        simulateProgress()
    }

    private fun simulateProgress() {
        mLineProgressBar?.startAnimator(4000, repeatCount = ValueAnimator.INFINITE)
        mSolidProgressBar?.startAnimator(4000, repeatCount = ValueAnimator.INFINITE)
        mCustomProgressBar1?.startAnimator(4000, repeatCount = ValueAnimator.INFINITE)
        mCustomProgressBar2?.startAnimator(3000, 100, 30, ValueAnimator.INFINITE)
        mCustomProgressBar3?.startAnimator(4000, repeatCount = ValueAnimator.INFINITE)
        mCustomProgressBar4?.startAnimator(4000, repeatCount = ValueAnimator.INFINITE)
        mCustomProgressBar5?.mOnPressedListener = object : CircleProgressBar.OnPressedListener {
            override fun onPressEnd() {
                toast("press end")
            }

            override fun onPressStart() {
                toast("press start")
            }

            override fun onPressProcess(progress: Int) {
                Utils.logE("PROGRESS", "progress: $progress")
            }

            override fun onPressInterrupt(progress: Int) {
                toast("press interrupt: $progress")
            }

        }
        mCustomProgressBar6?.startAnimator(4000, 20, 80, ValueAnimator.INFINITE)
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
