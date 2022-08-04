package com.example.signup.firebase.service

import com.example.signup.base.interfaces.BaseLogin
import com.example.signup.base.services.BaseUserLoginService

class FirebaseUserLoginService() : BaseUserLoginService(){
    override val loginService: BaseLogin = FirebaseLogin()
}