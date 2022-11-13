package com.dashingqi.framework.mvvm.viewmodel

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import java.lang.ref.WeakReference

/**
 * @desc : BaseViewModel
 * @author : zhangqi
 * @time : 2022/11/13 12:52
 */
class BaseViewModel(application: Application) : AndroidViewModel(application) {

    /** activity 的弱引用*/
    private var mActivityWeakReference: WeakReference<Activity>? = null

    /** Fragment 的弱引用*/
    private var mFragmentWeakReference: WeakReference<Fragment>? = null

    /** 绑定的activity */
    val mActivity: Activity?
        get() = mActivityWeakReference?.get()

    /** 绑定的fragment */
    val mFragment: Fragment?
        get() = mFragmentWeakReference?.get()

    /** 设置Activity */
    fun setActivity(activity: Activity) {
        mActivityWeakReference = WeakReference(activity)
    }

    /** 设置Fragment */
    fun setFragment(fragment: Fragment) {
        mFragmentWeakReference = WeakReference(fragment)
    }

}