package com.example.signup.parse.service

import android.util.Log
import com.example.signup.base.interfaces.BaseVerificationService

class ParseEmailNotification : BaseVerificationService {
    override fun send(to: String, message: String) {
        Log.d("Notification", "parse send $to: $message")
    }
}