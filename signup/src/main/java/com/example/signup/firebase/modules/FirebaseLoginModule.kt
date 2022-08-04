package com.example.signup.firebase.modules

import com.example.signup.base.services.BaseUserLoginService
import com.example.signup.firebase.service.FirebaseLogin
import com.example.signup.firebase.service.FirebaseUserLoginService
import dagger.Module
import dagger.Provides

@Module
class FirebaseLoginModule {
    @Provides
    fun getUserLoginService(): BaseUserLoginService = FirebaseUserLoginService()

    @Provides
    fun getFirebaseLogin():FirebaseLogin = FirebaseLogin()
}