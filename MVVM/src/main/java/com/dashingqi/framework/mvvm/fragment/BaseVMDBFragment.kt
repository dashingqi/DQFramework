package com.dashingqi.framework.mvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.dashingqi.framework.mvvm.ext.createBindingWithGeneric
import com.dashingqi.framework.mvvm.viewmodel.BaseViewModel

/**
 * @desc : BaseFragment + BaseViewModel + DataBinding
 * @author : zhangqi
 * @time : 2022/11/13 18:34
 */
abstract class BaseVMDBFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVMFragment<VM>() {

    /** DataBinding */
    private var _binding: DB? = null
    val mDataBinding: DB
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = createBindingWithGeneric<DB>(inflater, container, false, 1)
        return mDataBinding.root
    }

    override fun getLayoutId(): Int = 0

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}