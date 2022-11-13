package com.dashingqi.framework.mvvm.activity

import android.view.View
import androidx.viewbinding.ViewBinding
import com.dashingqi.framework.mvvm.ext.createBindingWithGeneric
import com.dashingqi.framework.mvvm.viewmodel.BaseViewModel

/**
 * @desc : BaseActivity + ViewModel + ViewBinding
 * @author : zhangqi
 * @time : 2022/11/13 11:40
 */
abstract class BaseVMVBActivity<VM : BaseViewModel, VB : ViewBinding> : BaseVMActivity<VM>() {

    /** ViewBinding */
    lateinit var mViewBinding: VB
        private set

    override fun getLayoutView(): View? {
        mViewBinding = createBindingWithGeneric(layoutInflater,1)
        return mViewBinding.root
    }

}