package com.prasant.loginwithfirebaseandlocal.domain.repository

import com.prasant.loginwithfirebaseandlocal.domain.model.User
import kotlinx.coroutines.flow.Flow
import com.prasant.loginwithfirebaseandlocal.utils.Result

interface AuthRepository {
    fun loginUser(email: String, password: String): Flow<Result<Unit>>
    fun registerUser(email: String, password: String): Flow<Result<Unit>>
    fun logoutUser(): Flow<User?>
}