package com.example.testapp.data.remote

import com.example.testapp.data.remote.dto.LoginResponseDto
import com.example.testapp.data.remote.dto.RegisterResponseDto
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("reg.php")
    suspend fun registerUser(
        @Field("NAME") name: String,
        @Field("PERSONAL_GENDER") personalGender: String,
        @Field("PERSONAL_BIRTHDAY") personalBirthday: String,
        @Field("PERSONAL_MOBILE") personalMobile: String,
        @Field("EMAIL") email: String,
        @Field("WORK_COMPANY") workCompany: String,
        @Field("UF_SERVICE_NUMBER") ufServiceNumber: String,
        @Field("LOGIN") login: String,
        @Field("PASSWORD") password: String,
        @Field("CONFIRM_PASSWORD") confirmPassword: String
    ): RegisterResponseDto

    @FormUrlEncoded
    @POST("auth.php")
    suspend fun loginUser(
        @Field("login") login: String,
        @Field("password") password: String
    ): LoginResponseDto

    companion object {
        const val BASE_URL = "http://gg-web.ru/api/"
    }
}