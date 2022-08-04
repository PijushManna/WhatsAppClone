package com.example.signup.base.services

import androidx.lifecycle.MutableLiveData
import api.APIResponse
import com.example.signup.base.interfaces.BaseLogin

abstract class BaseUserLoginService{
    protected abstract val loginService: BaseLogin
    fun login(email: String,password: String, response: MutableLiveData<APIResponse>){
        if (isLoggedIn()) {
            loginService.login(email, password,response)
        }
    }
    fun isLoggedIn(): Boolean = loginService.isLoggedIn()
    fun logout() = loginService.logout()
}