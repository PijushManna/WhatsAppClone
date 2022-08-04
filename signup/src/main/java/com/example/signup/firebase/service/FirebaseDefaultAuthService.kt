package com.example.signup.firebase.service

import android.content.Context
import com.firebase.ui.auth.AuthUI

class FirebaseDefaultAuthService{
    fun start(context: Context, providers: List<AuthUI.IdpConfig>) {
        val auth = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        context.startActivity(auth)
    }
}