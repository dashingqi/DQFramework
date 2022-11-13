package com.dashingqi.framework.mvvm

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

/**
 * @desc : BaseActivity + ViewModel + VIewBinding
 * @author : zhangqi
 * @time : 2022/11/13 11:40
 */
abstract class BaseVMVBActivity<VM : ViewModel, VB : ViewBinding> : BaseVMActivity<VM>() {}