package com.example.testapp.data.remote.dto

import com.example.testapp.domain.model.LoginForm

data class LoginFormDto(
    val login: String,
    val password: String
) {
    fun toLoginForm(): LoginForm {
        return LoginForm(
            login = login,
            password = password
        )
    }
}
