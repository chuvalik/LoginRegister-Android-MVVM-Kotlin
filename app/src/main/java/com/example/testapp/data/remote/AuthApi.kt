package com.example.testapp.data.remote

import com.example.testapp.data.remote.dto.LoginFormDto
import com.example.testapp.data.remote.dto.LoginResponseDto
import com.example.testapp.data.remote.dto.RegistrationFormDto
import com.example.testapp.data.remote.dto.RegistrationResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("reg.php")
    suspend fun registerUser(
        @Body registrationFormDto: RegistrationFormDto
    ): RegistrationResponseDto

    @POST("auth.php")
    suspend fun loginUser(
        @Body loginFormDto: LoginFormDto
    ): LoginResponseDto

    companion object {
        const val BASE_URL = "http://gg-web.ru/api/"
    }
}