package com.example.signup.base.interfaces

interface BaseVerificationService {
    fun send(to:String, message:String)
}