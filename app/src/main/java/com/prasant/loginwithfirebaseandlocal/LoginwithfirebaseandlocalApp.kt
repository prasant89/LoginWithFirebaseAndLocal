package com.prasant.loginwithfirebaseandlocal

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LoginwithfirebaseandlocalApp: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        FirebaseAuth.getInstance().useAppLanguage()

        Log.d("FIREBASE", "Debug enabled")
    }
}