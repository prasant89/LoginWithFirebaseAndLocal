package com.prasant.loginwithfirebaseandlocal.presentation.screen.login

data class LoginState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)