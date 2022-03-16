package com.example.testapp.domain.model

import com.example.testapp.data.remote.dto.LoginResponseDto

data class LoginResponse(
    val status: Boolean,
    val id: String,
    val message: String
) {
    fun toLoginResponseDto(): LoginResponseDto {
        return LoginResponseDto(
            status = status,
            id = id,
            message = message
        )
    }
}
