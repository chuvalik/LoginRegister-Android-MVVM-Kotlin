package com.example.testapp.data.remote.dto

import com.example.testapp.domain.model.RegistrationResponse

data class RegistrationResponseDto(
    val USER_ID: String,
    val MESSAGE: String,
    val STATUS: String
) {
    fun toRegistrationResponse(): RegistrationResponse {
        return RegistrationResponse(
            userId = USER_ID,
            message = MESSAGE,
            status = STATUS
        )
    }
}
