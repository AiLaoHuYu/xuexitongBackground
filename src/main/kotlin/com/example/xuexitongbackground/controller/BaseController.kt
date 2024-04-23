package com.example.xuexitongbackground.controller

open class BaseController {

    companion object {
        const val OK: Int = 200

        //用户已经存在
        const val USER_EXIST: Int = 222

        //密码不一致
        const val PASSWORD_CONSISTENT_ERROR: Int = 123

        //登录错误(用户名或密码错误)
        const val LOGIN_ERROR: Int = 333

        //用户为空
        const val USER_NULL: Int = 444

        //异常
        const val ERROR: Int = 555
    }
}