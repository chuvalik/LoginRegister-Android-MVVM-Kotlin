package com.example.testapp.domain.model

import com.example.testapp.data.remote.dto.RegistrationResponseDto

data class RegistrationResponse(
    val userId: String,
    val message: String,
    val status: String
) {
    fun toRegistrationResponseDto(): RegistrationResponseDto {
        return RegistrationResponseDto(
            USER_ID = userId,
            MESSAGE = message,
            STATUS = status
        )
    }
}
