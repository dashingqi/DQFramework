@file:Suppress("UNCHECKED_CAST")

package com.dashingqi.framework.mvvm.ext

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * 变量为空以及不为空的逻辑处理
 * @receiver T? 接收者
 */
inline fun <T> T?.notNull(notNullAction: (T) -> Unit, nullAction: () -> Unit = {}) {
    if (this != null) {
        notNullAction.invoke(this)
    } else {
        nullAction.invoke()
    }
}


/**
 * 获取ViewModel Class对象
 * @param obj Any
 * @param VMIndex Int
 * @return Class<VM>
 */
fun <VM : ViewModel> getVmClass(obj: Any, VMIndex: Int = 0): Class<VM> {
    return getClassWithGeneric(obj, VMIndex)
}

/**
 * 获取CLass对象
 * @param obj Any
 * @param index Int
 * @return Class<CLZ>
 */
private fun <CLZ> getClassWithGeneric(obj: Any, index: Int = 0): Class<CLZ> {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[index] as Class<CLZ>
}


/**
 * 创建Binding对象
 * @receiver AppCompatActivity
 * @param layoutInflater LayoutInflater
 * @return VB
 */
fun <VB : ViewBinding> AppCompatActivity.createBindingWithGeneric(
    layoutInflater: LayoutInflater, bindingIndex: Int = 0
): VB {
    val bindingClass = getClassWithGeneric<VB>(this, bindingIndex)
    val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)
    return (inflateMethod.invoke(null, layoutInflater) as VB).also {
        if (it is ViewDataBinding) {
            it.lifecycleOwner = this
        }
    }
}

/**
 * 创建Binding对象
 * @receiver Fragment
 * @param layoutInflater LayoutInflater
 * @return VB
 */
fun <VB : ViewBinding> Fragment.createBindingWithGeneric(
    layoutInflater: LayoutInflater, parent: ViewGroup?, attachToParent: Boolean, bindingIndex: Int = 0
): VB {
    val bindingClass = getClassWithGeneric<VB>(this, bindingIndex)
    val inflateMethod =
        bindingClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
    return (inflateMethod.invoke(null, layoutInflater,parent,attachToParent) as VB).also {
        if (it is ViewDataBinding) {
            it.lifecycleOwner = this
        }
    }
}