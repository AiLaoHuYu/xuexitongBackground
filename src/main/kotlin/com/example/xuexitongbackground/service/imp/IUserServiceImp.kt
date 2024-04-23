package com.example.xuexitongbackground.service.imp

import com.example.xuexitongbackground.data.User
import com.example.xuexitongbackground.mapper.UserMapper
import com.example.xuexitongbackground.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IUserServiceImp : IUserService {

    private lateinit var userMapper: UserMapper

    @Autowired
    constructor(userMapper: UserMapper) {
        this.userMapper = userMapper
    }


    override fun findUserByName(name: String): User {
        val user = userMapper.findByUserName(name)
        println("user: ${user.toString()}")
        return user
    }

    override fun insertUser(user: User): Int {
        val result = userMapper.insertUser(user)
        println("result: $result")
        return result
    }
}