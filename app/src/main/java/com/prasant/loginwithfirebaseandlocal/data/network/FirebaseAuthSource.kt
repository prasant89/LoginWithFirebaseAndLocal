package com.prasant.loginwithfirebaseandlocal.data.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlinx.coroutines.tasks.await
import com.prasant.loginwithfirebaseandlocal.utils.Result

class FirebaseAuthSource @Inject constructor(private  val auth:FirebaseAuth) {

    fun login(email: String, password: String): Flow<Result<FirebaseUser>> = flow {
        emit(Result.Loading)
        try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            emit(Result.Success(result.user!!))
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Login failed"))
        }
    }
}