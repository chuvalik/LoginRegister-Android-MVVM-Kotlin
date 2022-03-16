package com.example.testapp.domain.repository

import com.example.testapp.core.utils.Resource
import com.example.testapp.domain.model.LoginForm
import com.example.testapp.domain.model.LoginResponse
import com.example.testapp.domain.model.RegistrationForm
import com.example.testapp.domain.model.RegistrationResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun registerUser(registrationForm: RegistrationForm): Flow<Resource<RegistrationResponse>>

    suspend fun loginUser(loginForm: LoginForm): Flow<Resource<LoginResponse>>
}