package com.dashingqi.framework.mvvm.activity

import androidx.lifecycle.ViewModelProvider
import com.dashingqi.framework.mvvm.ext.getVmClass
import com.dashingqi.framework.mvvm.viewmodel.BaseViewModel

/**
 * @desc : BaseActivity + ViewModel
 * @author : zhangqi
 * @time : 2022/11/13 11:40
 */
abstract class BaseVMActivity<VM : BaseViewModel> : BaseActivity() {

    /** ViewModel*/
    lateinit var mViewModel: VM

    /** 创建ViewModel */
    private fun createViewModel(): VM {
        val vmClass = getVmClass<VM>(this, 0)
        return getViewModelFactory()?.let {
            ViewModelProvider(this, it)[vmClass]
        } ?: ViewModelProvider(this)[vmClass]
    }

    override fun performInit() {
        mViewModel = createViewModel()
    }

    /**
     * 如果你想传递参数到ViewModel中
     * 可以重写这个方法，通过Factory 重新构造一个带参数的ViewModel
     */
    open fun getViewModelFactory(): ViewModelProvider.Factory? {
        return null
    }

}