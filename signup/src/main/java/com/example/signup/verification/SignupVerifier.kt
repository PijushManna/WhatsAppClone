package com.example.signup.verification

object SignupVerifier {
    fun isUsernameValid(username: String?): Boolean {
        if (username.isNullOrBlank()){
            return false
        }
        return true
    }

    fun isPasswordValid(password: String?): Boolean{
        if (password.isNullOrBlank()){
            return false
        }
        return true
    }

    fun isEmailValid(email: String?):Boolean{
        if (email.isNullOrBlank()){
            return false
        }
        return true
    }

    fun isPhoneNoValid(phone: String?):Boolean{
        return true
    }
}