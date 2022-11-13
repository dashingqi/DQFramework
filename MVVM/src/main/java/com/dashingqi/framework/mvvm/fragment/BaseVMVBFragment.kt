package com.dashingqi.framework.mvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.dashingqi.framework.mvvm.ext.createBindingWithGeneric
import com.dashingqi.framework.mvvm.viewmodel.BaseViewModel

/**
 * @desc : BaseFragment + BaseViewModel + ViewBinding
 * @author : zhangqi
 * @time : 2022/11/13 18:51
 */
abstract class BaseVMVBFragment<VM : BaseViewModel, VB : ViewBinding> : BaseVMFragment<VM>() {

    override fun getLayoutId(): Int = 0

    /** ViewBinding */
    private var _binding: VB? = null
    val mViewBinding: VB
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = createBindingWithGeneric<VB>(inflater, container, false, 1)
        return mViewBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}