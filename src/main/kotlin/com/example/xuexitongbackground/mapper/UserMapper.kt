package com.example.xuexitongbackground.mapper

import com.example.xuexitongbackground.data.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun findByUserName(name: String): User
    fun insertUser(user: User): Int
    fun deleteUserByUserName(name: String): Int

}