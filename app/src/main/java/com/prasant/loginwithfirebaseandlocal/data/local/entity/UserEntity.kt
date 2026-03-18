package com.prasant.loginwithfirebaseandlocal.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val userID : String,
    val email : String
)