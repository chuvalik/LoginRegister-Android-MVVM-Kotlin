package com.example.testapp.data.remote.dto

import com.example.testapp.domain.model.LoginResponse

data class LoginResponseDto(
    val status: Boolean,
    val id: String,
    val message: String
) {
    fun toLoginResponse(): LoginResponse {
        return LoginResponse(
            status = status,
            id = id,
            message = message
        )
    }
}
