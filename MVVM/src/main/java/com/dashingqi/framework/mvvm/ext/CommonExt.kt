package com.dashingqi.framework.mvvm.ext

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