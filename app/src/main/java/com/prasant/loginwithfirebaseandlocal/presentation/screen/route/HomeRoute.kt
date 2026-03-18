package com.prasant.loginwithfirebaseandlocal.presentation.screen.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prasant.loginwithfirebaseandlocal.presentation.screen.home.HomeScreen
import com.prasant.loginwithfirebaseandlocal.presentation.screen.home.HomeViewModel

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(state = state)
}