package com.prasant.loginwithfirebaseandlocal.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prasant.loginwithfirebaseandlocal.presentation.screen.route.HomeRoute
import com.prasant.loginwithfirebaseandlocal.presentation.screen.route.LoginRoute
import com.prasant.loginwithfirebaseandlocal.presentation.screen.route.Routes

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {

        composable(Routes.LOGIN) {
            LoginRoute(
                onLoginSuccess = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.HOME) {
            HomeRoute()
        }
    }
}