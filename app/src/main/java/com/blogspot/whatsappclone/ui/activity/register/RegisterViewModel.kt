package com.blogspot.whatsappclone.ui.activity.register

import androidx.lifecycle.ViewModel
import com.example.signup.parse.ParseLogin
import com.example.signup.repo.LoginRepo

class RegisterViewModel : ViewModel() {
    private val loginRepo: LoginRepo by lazy { LoginRepo(ParseLogin()) }
    fun signUp(){
        loginRepo.signUp()
    }
}