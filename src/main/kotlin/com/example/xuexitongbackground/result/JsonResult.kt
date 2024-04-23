package com.example.xuexitongbackground.result

import com.alibaba.fastjson.JSON
import lombok.Getter
import lombok.Setter
import java.io.Serializable

@Setter
@Getter
class JsonResult<T> : Serializable {
    private var code: Int
    private var message: String
    private var state = 0
    private var data: T

//    constructor(code: Int, message: String) {
//        this.code = code
//        this.message = message
//    }

    constructor(code: Int, message: String, data: T) {
        this.code = code
        this.message = message
        this.data = data
    }


    // 构造函数，getter和setter等
    constructor(code: Int, message: String, data: T, state: Int) {
        this.code = code
        this.message = message
        this.data = data
        this.state = state
    }

    companion object {
        // 提供一些静态方法用于快速创建不同状态的 JsonResult 对象
        fun success(code: Int, message: String): String {
            return JSON.toJSONString(JsonResult(code, message, null).toString())
        }

        fun <T> success(code: Int, message: String, data: T): String {
            return JSON.toJSONString(JsonResult(code, message, data).toString())
        }

        fun error(code: Int, message: String): String {
            return JSON.toJSONString(JsonResult(code, message, null).toString())
        }

        fun <T> error(code: Int, message: String, data: T): String {
            return JSON.toJSONString(JsonResult(code, message, data).toString())
        }
    }

    override fun toString(): String {
        return "{code:$code,message:$message,data:${data.toString()}}"
    }
}