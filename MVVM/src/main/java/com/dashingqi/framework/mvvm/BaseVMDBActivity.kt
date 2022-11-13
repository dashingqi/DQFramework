package com.dashingqi.framework.mvvm

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 * @desc : BaseActivity + ViewModel + DataBinding
 * @author : zhangqi
 * @time : 2022/11/13 11:40
 */
abstract class BaseVMDBActivity<VM : ViewModel, DB : ViewDataBinding> : BaseVMActivity<VM>() {}