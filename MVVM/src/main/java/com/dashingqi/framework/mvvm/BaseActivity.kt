package com.dashingqi.framework.mvvm

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * @desc : BaseActivity
 * @author : zhangqi
 * @time : 2022/11/13 11:39
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView(savedInstanceState)
    }

    /**
     * 子类声明的布局ID
     * @return Int 返回布局ID
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * 获取布局View
     * @return View? 布局View
     */
    abstract fun getLayoutView(): View?

    /**
     * 初始化布局
     * @param savedInstanceState Bundle? Bundle对象
     */
    abstract fun initView(savedInstanceState: Bundle?)
}