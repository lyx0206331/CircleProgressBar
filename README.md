# CircleProgressBar
简单环形进度条实现，带进度显示，可设置居中图片，可显示进度值，可选择进度样式，可选择动画效果，也可当按下时带进度的按钮使用

![image](https://github.com/lyx0206331/CircleProgressBar/blob/master/previews/screenshot_0.png?raw=true)
![gif](https://github.com/lyx0206331/CircleProgressBar/blob/master/previews/record.gif?raw=true)

v0.0.7更新：
- 修正部分bug

v0.0.6更新：
- CircleProgressBar作响应按下操作按钮使用时，如果手势移出控件范围，自动中断按下响应
- CircleProgressBar作响应按下操作按钮使用时，支持连续进度
- 新增基于LinearLayout的子布局CircleProgressLinearLayout，布局带环形进度条
- 新增基于FrameLayout的子布局CircleProgressFrameLayout，布局带环形进度条

使用方法：

Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.lyx0206331:CircleProgressBar:0.0.6'
	}


xml布局文件中如下：  
```XML
<com.adrian.circleprogressbarlib.CircleProgressBar  
    	android:id="@+id/continuable_progress5"  
    	android:layout_width="50dp"  
	android:layout_height="50dp"  
	android:layout_margin="@dimen/default_margin"  
	android:clickable="true"  
	app:cpb_background_color="@android:color/transparent"  
	app:cpb_end_color="@color/holo_green_light"  
	app:cpb_start_color="@color/holo_green_light"  
	app:cpb_stroke_width="3dp"  
	app:cpb_text_color="@color/holo_green_light"  
	app:cpb_style="solid_line"  
	app:cpb_stop_anim_type="reverse_stop"  
	app:cpb_center_color="@color/holo_blue_dark"  
	app:cpb_show_value="true"  
	app:cpb_center_src="@mipmap/ic_launcher_round"  
	app:cpb_continuable="true"/>  
```
	   
或者：  
```XML
<com.adrian.circleprogressbarlib.CircleProgressLinearLayout  
	android:id="@+id/cpll"  
	android:layout_width="100dp"  
	android:layout_height="100dp"  
	android:layout_margin="@dimen/default_margin"   
	android:gravity="center"  
	android:orientation="vertical"  
	android:clickable="true"  
	app:cpl_background_color="@android:color/transparent"  
	app:cpl_end_color="@color/holo_green_light"  
	app:cpl_start_color="@color/holo_red_light"  
	app:cpl_stroke_width="3dp"  
	app:cpl_center_color="@color/holo_blue_dark"  
	app:cpl_style="solid_line"  
	app:cpl_stop_anim_type="reverse_stop"  
	app:cpb_continuable="true"
	app:cpl_isLinkChildTouchEvent="true">   
	<TextView  
		android:id="@+id/tvCenter"  
		android:layout_width="wrap_content"  
		android:layout_height="wrap_content"  
		android:textColor="#ffffff"/>  
	<Button  
		android:id="@+id/btnCenter"  
		android:layout_width="wrap_content"  
		android:layout_height="wrap_content" />  
</com.adrian.circleprogressbarlib.CircleProgressLinearLayout>  
```

Activity中使用如下：  
非按下响应时，动画调用:  
```Kotlin
 mCustomProgressBar6?.startAnimator(4000, 20, 80, ValueAnimator.INFINITE)
 或
 mCustomProgressBar6?.startAnimator()
```

格式化居中数值显示:  
```Kotlin
continuable_progress5.mProgressFormatter = object : CircleProgressBar.ProgressFormatter {
            override fun format(progress: Int, max: Int): CharSequence {
                return "${progress}c"
            }

        }
```
按下响应:  
```Kotlin
continuable_progress5.mOnPressedListener = object : CircleProgressBar.OnPressedListener {
            override fun onPressEnd() {
                toast("press end")
            }

            override fun onPressStart() {
                toast("press start")
            }

            override fun onPressProcess(progress: Int) {
//                Utils.logE("PROGRESS", "progress: $progress")
            }

            override fun onPressInterrupt(progress: Int) {
                toast("press interrupt: $progress")
            }

        }
```

参数说明:  

名称 | 类型 | 说明
------------ | ------------- | -------------
cpb_line_count | intege/reference | 刻度圆环时刻度数量
cpb_line_width | dimension/reference | 刻度圆环时刻度宽度
cpb_start_color | color/reference | 渐变开始颜色
cpb_end_color | color/reference | 渐变结束颜色
cpb_text_color | color/reference | 居中文本颜色
cpb_text_size | dimension/reference | 居中文本大小
cpb_stroke_width | dimension/reference | 进度条宽度
cpb_background_color | color/reference | 进度条背景色
cpb_start_degree | float/reference | 进度条起始角度
cpb_drawBackgroundOutsideProgress | boolean/reference | 进度条是否渐隐形式
cpb_center_src | reference | 居中图片
cpb_center_color | color/reference | 居中颜色
cpb_show_value | boolean/reference | 是否显示居中数值
cpb_continuable | boolean/reference | 进度是否持续累加
cpb_stop_anim_type | enum(simple_stop,reverse_stop) | 非累加进度时的终止动画(simple_stop表示直接回到进度0，reverse_stop表示依次递减到0)
cpb_style | enum(line,solid,solid_line) | 进度样式(line为刻度样式,solid为实心样式,solid_line为线条样式)
cpb_shader | enum(linear,radial,sweep) | 渐变样式(linear为线性渐变,radial为径向渐变,sweep为扫描式渐变)
cpb_stroke_cap | enum(butt,round,square) | 线条进度起止位置样式(butt为无样式,round为圆形样式,square为方形样式)

CircleProgressFrameLayout与CircleProgressLinearLayout参数类似，但去除中间数值显示功能，新增子控件关联响应，参数前缀*cpb*改为*cpl*。区别如下：

名称 | 类型 | 说明
------ | ----- | -----
~~cpb_text_color~~ | color/reference | 居中文本颜色
~~cpb_text_size~~ | dimension/reference | 居中文本大小
~~cpb_center_src~~ | reference | 居中图片
~~cpb_show_value~~ | boolean/reference | 是否显示居中数值
cpl_isLinkChildTouchEvent | boolean/reference | 是否关联子控件触摸事件
