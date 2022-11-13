package com.dashingqi.framework.mvvm.activity

import android.view.View
import androidx.databinding.ViewDataBinding
import com.dashingqi.framework.mvvm.ext.createBindingWithGeneric
import com.dashingqi.framework.mvvm.viewmodel.BaseViewModel

/**
 * @desc : BaseActivity + ViewModel + DataBinding
 * @author : zhangqi
 * @time : 2022/11/13 11:40
 */
abstract class BaseVMDBActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVMActivity<VM>() {

    /** DataBinding */
    lateinit var mDataBinding: DB
        private set

    override fun getLayoutId(): Int = 0

    /**
     * 获取到布局View
     * @return View?
     */
    override fun getLayoutView(): View? {
        mDataBinding = createBindingWithGeneric(layoutInflater, 1)
        return mDataBinding.root
    }
}