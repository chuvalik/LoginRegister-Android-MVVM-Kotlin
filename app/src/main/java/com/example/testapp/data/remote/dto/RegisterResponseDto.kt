package com.example.testapp.data.remote.dto

import com.example.testapp.domain.model.RegisterResponse

data class RegisterResponseDto(
    val USER_ID: String,
    val MESSAGE: String,
    val STATUS: String
) {
    fun toRegistrationResponse(): RegisterResponse {
        return RegisterResponse(
            userId = USER_ID,
            message = MESSAGE,
            status = STATUS
        )
    }
}
