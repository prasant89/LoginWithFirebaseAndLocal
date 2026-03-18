package com.prasant.loginwithfirebaseandlocal.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.prasant.loginwithfirebaseandlocal.data.local.AppDatabase
import com.prasant.loginwithfirebaseandlocal.data.local.dao.UserDao
import com.prasant.loginwithfirebaseandlocal.data.network.FirebaseAuthSource
import com.prasant.loginwithfirebaseandlocal.data.repository.AuthRepositoryImpl
import com.prasant.loginwithfirebaseandlocal.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth =
        FirebaseAuth.getInstance()

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "db").build()

    @Provides
    fun provideDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideRepository(
        firebase: FirebaseAuthSource,
        dao: UserDao
    ): AuthRepository = AuthRepositoryImpl(firebase, dao)
}