package com.example.testapp.data.remote.dto

import com.example.testapp.domain.model.RegistrationForm

data class RegistrationFormDto(
    val NAME: String,
    val PERSONAL_GENDER: String,
    val PERSONAL_BIRTHDAY: String,
    val PERSONAL_MOBILE: String,
    val EMAIL: String,
    val WORK_COMPANY: String,
    val UF_SERVICE_NUMBER: String,
    val LOGIN: String,
    val PASSWORD: String,
    val CONFIRM_PASSWORD: String,
) {
    fun toRegistrationForm(): RegistrationForm {
        return RegistrationForm(
            name = NAME,
            personalGender = PERSONAL_GENDER,
            personalBirthday = PERSONAL_BIRTHDAY,
            personalMobile = PERSONAL_MOBILE,
            email = EMAIL,
            workCompany = WORK_COMPANY,
            ufServiceNumber = UF_SERVICE_NUMBER,
            login = LOGIN,
            password = PASSWORD,
            confirmPassword = CONFIRM_PASSWORD
        )
    }
}
