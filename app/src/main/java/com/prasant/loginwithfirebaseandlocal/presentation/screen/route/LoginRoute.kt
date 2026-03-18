package com.prasant.loginwithfirebaseandlocal.presentation.screen.route

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prasant.loginwithfirebaseandlocal.presentation.screen.login.LoginScreen
import com.prasant.loginwithfirebaseandlocal.presentation.screen.login.LoginViewModel

@Composable
fun LoginRoute(
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess) onLoginSuccess()
    }

    LoginScreen(
        state = state,
        onLoginClick = viewModel::login
    )
}