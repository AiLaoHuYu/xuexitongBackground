package com.example.xuexitongbackground.controller

import com.example.xuexitongbackground.data.User
import com.example.xuexitongbackground.result.JsonResult
import com.example.xuexitongbackground.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/user")
class UserController : BaseController() {

    @Autowired
    private lateinit var userService: IUserService

    private final val noPrev = "xuxitong"

    @RequestMapping("/login")
    fun login(userName: String, password: String): String {
        println("username: $userName password: $password")
        val user = userService.findUserByName(userName)
        if (user == null) {
            return JsonResult.error(ERROR, "用户不存在")
        }
        if (password != user.password) {
            return JsonResult.error(ERROR, "密码或用户名错误")
        }
        return JsonResult.success(OK, "用户登录成功",user)
    }


    @RequestMapping("/insert")
    fun insert(userName: String, password: String): String {
        val findUser = userService.findUserByName(userName)
        if (findUser != null) {
            return JsonResult.error(ERROR, "用户已经存在", findUser)
        }
        val user = User()
        val random = Random()
        user.no = noPrev + random.nextInt(100000)
        user.name = userName
        user.password = password
        user.phone = ""
        user.email = ""
        user.createdUser = userName
        user.modifiedUser = userName
        user.createdTime = Date()
        user.modifiedTime = Date()
        val result = userService.insertUser(user)
        return if (result == 1)
            JsonResult.success(OK, "用户注册成功", user)
        else
            JsonResult.error(ERROR, "后台数据库插入失败，请联系管理员")

    }


}