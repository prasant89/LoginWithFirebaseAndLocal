package com.prasant.loginwithfirebaseandlocal.data.model

import com.google.firebase.auth.FirebaseUser
import com.prasant.loginwithfirebaseandlocal.data.local.entity.UserEntity
import com.prasant.loginwithfirebaseandlocal.domain.model.User

fun FirebaseUser.toEntity() = UserEntity(
    userID = uid,
    email = email ?: ""
)

fun UserEntity.toDomain() = User(userID, email)