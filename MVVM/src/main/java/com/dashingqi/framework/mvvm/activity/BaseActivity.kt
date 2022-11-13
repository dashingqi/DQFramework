package com.dashingqi.framework.mvvm.activity

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.dashingqi.framework.mvvm.ext.notNull

/**
 * @desc : BaseActivity
 * @author : zhangqi
 * @time : 2022/11/13 11:39
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutView().notNull(notNullAction = {
            setContentView(it)
        }, nullAction = {
            setContentView(getLayoutId())
        })
        performInit()
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

    /**
     * 初始化,不强制实现
     */
    open fun performInit(){

    }
}