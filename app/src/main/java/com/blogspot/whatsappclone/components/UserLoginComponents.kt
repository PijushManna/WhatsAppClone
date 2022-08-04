package com.blogspot.whatsappclone.components

import com.blogspot.whatsappclone.ui.activity.login.LoginActivity
import com.blogspot.whatsappclone.ui.activity.main.MainActivity
import com.blogspot.whatsappclone.ui.activity.splash.SplashActivity
import com.example.signup.firebase.modules.FirebaseLoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FirebaseLoginModule::class])
interface UserLoginComponents {
    fun inject(activity: SplashActivity)
    fun inject(activity: MainActivity)
    fun inject(activity: LoginActivity)
}