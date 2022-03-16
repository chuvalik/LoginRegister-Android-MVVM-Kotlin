package com.example.testapp.data.remote.dto

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
)
