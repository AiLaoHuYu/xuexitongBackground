package com.example.xuexitongbackground.data

import com.fasterxml.jackson.annotation.JsonFormat
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
class User {
    lateinit var no: String
    lateinit var name: String
    lateinit var password: String
    lateinit var phone: String
    var age: Int = -1
    var sex: Int = -1
    lateinit var email: String
    var roleId: Int = 2
    var isDelete = -1
    lateinit var createdUser: String

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    lateinit var createdTime: Date
    lateinit var modifiedUser: String

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    lateinit var modifiedTime: Date

    override fun toString(): String {
        return "{name:$name,password:$password,age:$age,sex:$sex,email:$email,roleId:$roleId,isDelete:$isDelete," +
                "createdUser:$createdUser,createdTime:$createdTime,modifiedUser:$modifiedUser,modifiedTime:$modifiedTime}"
    }

}