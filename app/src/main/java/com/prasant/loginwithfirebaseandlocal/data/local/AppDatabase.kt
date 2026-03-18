package com.prasant.loginwithfirebaseandlocal.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prasant.loginwithfirebaseandlocal.data.local.dao.UserDao
import com.prasant.loginwithfirebaseandlocal.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}