package com.example.testapp.domain.model

import com.example.testapp.data.remote.dto.LoginFormDto

data class LoginForm(
    val login: String,
    val password: String
) {
    fun toLoginFormDto(): LoginFormDto {
        return LoginFormDto(
            login = login,
            password = password
        )
    }
}
