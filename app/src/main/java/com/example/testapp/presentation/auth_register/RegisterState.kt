package com.example.testapp.presentation.auth_register

import com.example.testapp.domain.model.RegisterResponse

sealed class RegisterState {
    class Success(val response: RegisterResponse): RegisterState()
    class Failure(val errorText: String): RegisterState()
    object Empty: RegisterState()
}