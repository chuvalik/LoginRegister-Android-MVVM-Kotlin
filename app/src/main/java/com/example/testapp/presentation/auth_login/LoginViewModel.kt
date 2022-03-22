package com.example.testapp.presentation.auth_login

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
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Empty)
    val loginState = _loginState.asStateFlow()

    fun loginUser(login: String, password: String) {
        viewModelScope.launch {
            when (val response = repository.loginUser(login, password)) {
                is Resource.Success -> _loginState.value = LoginState.Success(response.data!!)
                is Resource.Error -> _loginState.value =
                    LoginState.Failure(
                        response.error ?: "Unknown error."
                    )
                else -> Unit
            }
        }
    }
}