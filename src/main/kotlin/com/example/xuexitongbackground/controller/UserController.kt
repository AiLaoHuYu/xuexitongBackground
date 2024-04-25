package com.example.xuexitongbackground.controller

import com.example.xuexitongbackground.data.User
import com.example.xuexitongbackground.result.JsonResult
import com.example.xuexitongbackground.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
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
        if (StringUtils.isEmpty(user.email)) {
            user.email = "null@qq.com"
        }
        if (StringUtils.isEmpty(user.phone)) {
            user.phone = "1234567"
        }
        val currentDate = Date()
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val dateString = sdf.format(currentDate)
        val date = sdf.parse(dateString)
        println("date $date")
        user.createdTime = date
        user.modifiedTime = date
        return JsonResult.success(OK, "用户登录成功", user)
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
        val currentDate = Date()
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val dateString = sdf.format(currentDate)
        val date = sdf.parse(dateString)
        println("date $date")
        user.createdTime = date
        user.modifiedTime = date
        val result = userService.insertUser(user)
        return if (result == 1)
            JsonResult.success(OK, "用户注册成功", user)
        else
            JsonResult.error(ERROR, "后台数据库插入失败，请联系管理员")

    }


}