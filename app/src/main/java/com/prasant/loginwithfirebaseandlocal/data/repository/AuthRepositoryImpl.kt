package com.prasant.loginwithfirebaseandlocal.data.repository

import com.prasant.loginwithfirebaseandlocal.data.local.dao.UserDao
import com.prasant.loginwithfirebaseandlocal.data.model.toEntity
import com.prasant.loginwithfirebaseandlocal.data.network.FirebaseAuthSource
import com.prasant.loginwithfirebaseandlocal.domain.model.User
import com.prasant.loginwithfirebaseandlocal.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import com.prasant.loginwithfirebaseandlocal.utils.Result
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuthSource: FirebaseAuthSource,
    private val dao: UserDao
) : AuthRepository {

    override fun loginUser(
        email: String,
        password: String
    ): Flow<Result<Unit>> = flow {

        emit(Result.Loading)

        firebaseAuthSource.login(email, password).collect { result ->
            when (result) {

                is Result.Success -> {
                    dao.insertUser(result.data.toEntity())
                    emit(Result.Success(Unit))
                }

                is Result.Error -> {
                    emit(Result.Error(result.message))
                }

                is Result.Loading -> {
                    emit(Result.Loading)
                }
            }
        }
    }

    override fun registerUser(
        email: String,
        password: String
    ): Flow<Result<Unit>> {
        TODO("Not yet implemented")
    }

    override fun logoutUser(): Flow<User?> {
        TODO("Not yet implemented")
    }
}