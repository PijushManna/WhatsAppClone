package com.example.signup.base.services

import androidx.lifecycle.MutableLiveData
import com.example.signup.base.interfaces.BaseUserRepository
import com.example.signup.base.interfaces.BaseVerificationService

class UserRegistrationService(private val userRepository: BaseUserRepository, private val verificationService: BaseVerificationService) {
    fun registerUser(email: String, password: String){
        userRepository.signUp(email,password,email,"", MutableLiveData())
        verificationService.send(email,"User Verification")
    }
}