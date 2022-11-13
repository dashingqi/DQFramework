package com.dashingqi.framework.mvvm.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * @desc : BaseFragment
 * @author : zhangqi
 * @time : 2022/11/13 18:29
 */
abstract class BaseFragment : Fragment() {

    /** Activity */
    lateinit var mActivity: AppCompatActivity
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        performInit()
        initView(view, savedInstanceState)
        initData()
    }

    /**
     * 获取布局ID
     * @return Int 布局ID
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * 初始化View
     */
    abstract fun initView(view: View, savedInstanceState: Bundle?)

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化操作，不强制实现
     */
    open fun performInit(){

    }
}