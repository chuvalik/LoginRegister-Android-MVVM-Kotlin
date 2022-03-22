package com.example.testapp.data.repository

import android.util.Log
import com.example.testapp.core.utils.Resource
import com.example.testapp.data.remote.AuthApi
import com.example.testapp.domain.model.LoginResponse
import com.example.testapp.domain.model.RegisterResponse
import com.example.testapp.domain.repository.AuthRepository
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val api: AuthApi
) : AuthRepository {

    override suspend fun registerUser(
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
    ): Resource<RegisterResponse> {
        return try {
            val response = api.registerUser(
                name,
                personalGender,
                personalBirthday,
                personalMobile,
                email,
                workCompany,
                ufServiceNumber,
                login,
                password,
                confirmPassword
            ).toRegistrationResponse()
            Resource.Success(response)
        } catch (e: HttpException) {
            Resource.Error(error = e.message ?: "Unknown error.")
        } catch (e: IOException) {
            Resource.Error(error = e.message ?: "Unknown error.")
        }
    }


    override suspend fun loginUser(login: String, password: String): Resource<LoginResponse> {
        return try {
            val response = api.loginUser(login, password).toLoginResponse()
            Resource.Success(response)
        } catch (e: HttpException) {
            Resource.Error(error = e.message ?: "Unknown error.")
        } catch (e: IOException) {
            Resource.Error(error = e.message ?: "Unknown error.")
        }
    }
}