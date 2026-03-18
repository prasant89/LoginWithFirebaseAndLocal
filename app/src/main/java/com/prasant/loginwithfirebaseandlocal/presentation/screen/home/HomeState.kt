package com.prasant.loginwithfirebaseandlocal.presentation.screen.home

import com.prasant.loginwithfirebaseandlocal.domain.model.User

data class HomeState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null
)