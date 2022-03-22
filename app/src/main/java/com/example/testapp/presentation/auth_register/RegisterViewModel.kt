package com.example.testapp.presentation.auth_register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.core.utils.Resource
import com.example.testapp.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _registerState = MutableStateFlow<RegisterState>(RegisterState.Empty)
    val registerState = _registerState.asStateFlow()

    fun registerUser(
        name: String,
        personalGender: String,
        personalBirthday: String,
        personalMobile: String,
        email: String,
        workCompany: String,
        ufServiceNumber: String,
        login: String,
        password: String,
        confirmPassword: String
    ) {
        viewModelScope.launch {
            when (val response = repository.registerUser(
                name,
                personalGender,
                personalBirthday,
                personalMobile,
                email,
                workCompany,
                ufServiceNumber,
                login,
                password,
                confirmPassword
            )) {
                is Resource.Success -> _registerState.value = RegisterState.Success(response.data!!)
                is Resource.Error -> _registerState.value =
                    RegisterState.Failure(
                        response.error ?: "Unknown error."
                    )
                else -> Unit
            }
        }
    }
}
