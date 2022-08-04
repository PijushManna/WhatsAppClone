package com.example.signup.base.interfaces

import androidx.lifecycle.MutableLiveData
import api.APIResponse

interface BaseLogin {
    fun login(email: String, password:String, response:MutableLiveData<APIResponse>)
    fun logout()
    fun isLoggedIn():Boolean
}