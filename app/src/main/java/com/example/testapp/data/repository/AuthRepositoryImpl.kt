package com.example.testapp.data.repository

import com.example.testapp.core.utils.Resource
import com.example.testapp.data.remote.AuthApi
import com.example.testapp.domain.model.LoginForm
import com.example.testapp.domain.model.RegistrationForm
import com.example.testapp.domain.repository.AuthRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val api: AuthApi
) : AuthRepository {
    override suspend fun registerUser(registrationForm: RegistrationForm) = flow {
        try {
            emit(Resource.Loading())
            val form = registrationForm.toRegistrationFormDto()
            val response = api.registerUser(form).toRegistrationResponse()
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Error(error = e.message ?: "Unknown error."))
        } catch (e: IOException) {
            emit(Resource.Error(error = e.message ?: "Unknown error."))
        }
    }

    override suspend fun loginUser(loginForm: LoginForm) = flow {
        try {
            emit(Resource.Loading())
            val form = loginForm.toLoginFormDto()
            val response = api.loginUser(form).toLoginResponse()
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Error(error = e.message ?: "Unknown error."))
        } catch (e: IOException) {
            emit(Resource.Error(error = e.message ?: "Unknown error."))
        }
    }
}