# CircleProgressBar
简单环形进度条实现，带进度显示，可设置居中图片，可显示进度值，可选择进度样式，可选择动画效果，也可当按下时带进度的按钮使用

如图：
    ![image](https://github.com/lyx0206331/CircleProgressBar/blob/master/previews/screenshot_0.png?raw=true)

v0.0.6更新：
1. CircleProgressBar作响应按下操作按钮使用时，如果手势移出控件范围，自动中断按下响应
2. CircleProgressBar作响应按下操作按钮使用时，支持连续进度
3. 新增基于LinearLayout的子布局CircleProgressLinearLayout，布局带环形进度条
3. 新增基于FrameLayout的子布局CircleProgressFrameLayout，布局带环形进度条

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

