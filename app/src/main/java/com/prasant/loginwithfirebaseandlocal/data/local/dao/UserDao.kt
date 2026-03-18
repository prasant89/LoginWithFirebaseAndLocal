package com.prasant.loginwithfirebaseandlocal.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prasant.loginwithfirebaseandlocal.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)
    @Query("SELECT * FROM users LIMIT 1")
    fun getUser(): Flow<UserEntity>
}