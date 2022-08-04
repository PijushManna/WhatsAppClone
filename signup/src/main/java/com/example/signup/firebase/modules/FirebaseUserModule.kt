package com.example.signup.firebase.modules

import com.example.signup.firebase.model.FirebaseBaseUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.Module
import dagger.Provides

@Module
class FirebaseUserModule {
    @Provides
    fun getBaseFirebaseUser(user: FirebaseUser?,mAuth: FirebaseAuth) : FirebaseBaseUser = FirebaseBaseUser(user,mAuth)

    @Provides
    fun getFirebaseUser():FirebaseUser? = FirebaseAuth.getInstance().currentUser

    @Provides
    fun getFirebaseAuth():FirebaseAuth = FirebaseAuth.getInstance()
}