package com.example.signup.firebase.service

import android.util.Log
import com.example.signup.base.interfaces.BaseVerificationService

private const val TAG = "FirebaseEmailNotify"
class FirebaseEmailVerification : BaseVerificationService {
    override fun send(to: String, message: String) {
        Log.i(TAG, "firebase send $to: $message")
    }
}