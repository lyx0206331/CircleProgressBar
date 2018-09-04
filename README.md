# CircleProgressBar
简单环形进度条实现，带进度显示，可设置居中图片，可显示进度值，可选择进度样式，可选择动画效果，也可当按下时带进度的按钮使用

![image](https://github.com/lyx0206331/CircleProgressBar/blob/master/previews/screenshot_0.png?raw=true)
![gif](https://github.com/lyx0206331/CircleProgressBar/blob/master/previews/record.gif?raw=true)

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

参数说明:  

参数名称 | 参数类型 | 参数说明
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
