package com.blogspot.whatsappclone.ui.activity.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import api.ApiResponse

class LoginViewModel() : ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val response = MutableLiveData<ApiResponse>()

    fun login(){

    }
}