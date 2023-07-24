package com.example.signup.firebase

import api.ApiResponse
import com.example.signup.base.LoginService
import com.example.signup.models.User
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class FirebaseLogin(private val firebaseInstance:FirebaseAuth) : LoginService {
    override suspend fun login(email: String, password: String): ApiResponse {
        return suspendCoroutine {continuation->
            firebaseInstance.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful){
                    continuation.resume(ApiResponse.Success())
                }
                if (it.exception!=null){
                    continuation.resume(ApiResponse.Error(it.exception))
                }
            }
        }
    }

    override suspend fun logout(): ApiResponse {
        firebaseInstance.signOut()
        return ApiResponse.Success()
    }

    override fun isLoggedIn(): Boolean {
        return firebaseInstance.currentUser != null
    }

    override suspend fun signUp(
        username: String,
        password: String,
        email: String,
        phone: String,
        about: String,
        imageUrl: String
    ): ApiResponse {
        return suspendCoroutine { continuation ->
            val res = firebaseInstance.createUserWithEmailAndPassword(email, password)
            if (res.isSuccessful){
                continuation.resume(ApiResponse.Success())
            }
            if (res.isCanceled){
                continuation.resume(ApiResponse.Error(Exception("Sign Up Cancelled!!")))
            }
            if (res.exception!=null){
                continuation.resume(ApiResponse.Error(res.exception))
            }
        }
    }

    override fun getCurrentUser(): User? {
        return firebaseInstance.currentUser?.let {
            User(it.uid,it.displayName ?: "",it.phoneNumber,"",it.photoUrl?.path)
        }
    }
}