package com.example.testapp.domain.repository

import com.example.testapp.core.utils.Resource
import com.example.testapp.domain.model.LoginResponse
import com.example.testapp.domain.model.RegisterResponse

interface AuthRepository {

    suspend fun registerUser(
        name: String,
        personalGender: String,
        personalBirthday: String,
        personalMobile: String,
        email: String,
        workCompany: String,
        ufServiceNumber: String,
        login: String,
        password: String,
        confirmPassword: String
    ): Resource<RegisterResponse>

    suspend fun loginUser(
        login: String,
        password: String
    ): Resource<LoginResponse>
}