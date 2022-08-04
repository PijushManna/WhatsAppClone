package com.example.signup.base

import com.example.signup.verification.SignupVerifier

open class BaseSignUp {
    protected fun isValid(
        username: String?,
        password: String?,
        email: String?,
        phone: String?
    ): Boolean {
        return SignupVerifier.isUsernameValid(username) && SignupVerifier.isPasswordValid(password) && SignupVerifier.isEmailValid(email) && SignupVerifier.isPhoneNoValid(phone)
    }
}