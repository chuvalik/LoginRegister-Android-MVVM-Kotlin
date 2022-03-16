package com.example.testapp.domain.model

import com.example.testapp.data.remote.dto.RegistrationFormDto

data class RegistrationForm(
    val name: String,
    val personalGender: String,
    val personalBirthday: String,
    val personalMobile: String,
    val email: String,
    val workCompany: String,
    val ufServiceNumber: String,
    val login: String,
    val password: String,
    val confirmPassword: String,
) {
    fun toRegistrationFormDto(): RegistrationFormDto {
        return RegistrationFormDto(
            NAME = name,
            PERSONAL_GENDER = personalGender,
            PERSONAL_BIRTHDAY = personalBirthday,
            PERSONAL_MOBILE = personalMobile,
            EMAIL = email,
            WORK_COMPANY = workCompany,
            UF_SERVICE_NUMBER = ufServiceNumber,
            LOGIN = login,
            PASSWORD = password,
            CONFIRM_PASSWORD = confirmPassword
        )
    }
}