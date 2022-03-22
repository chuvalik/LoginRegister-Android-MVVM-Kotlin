package com.example.testapp.presentation.auth_login

import com.example.testapp.domain.model.LoginResponse

sealed class LoginState {
    class Success(val response: LoginResponse) : LoginState()
    class Failure(val error: String): LoginState()
    object Empty: LoginState()
}