package com.blogspot.whatsappclone.ui.activity.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import api.APIResponse
import com.example.signup.base.interfaces.BaseLogin

class LoginViewModel(private val loginService: BaseLogin) : ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val response = MutableLiveData<APIResponse>()

    fun login(){
        if(email.value!=null && password.value!=null) {
            loginService.login(email.value!!, password.value!!, response)
        }
    }

    class LoginViewModelFactory(private val loginService: BaseLogin) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(loginService) as T
        }
    }
}