package com.example.xuexitongbackground.service

import com.example.xuexitongbackground.data.User


interface IUserService {

    fun findUserByName(name: String): User

    fun insertUser(user: User): Int

}