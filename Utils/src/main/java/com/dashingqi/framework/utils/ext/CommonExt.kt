package com.dashingqi.framework.utils.ext

/**
 * @desc : 通用的扩展
 * @author : zhangqi
 * @time : 2022/11/13 12:26
 */

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