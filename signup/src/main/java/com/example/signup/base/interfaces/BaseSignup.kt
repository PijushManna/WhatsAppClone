package com.example.signup.base.interfaces

import androidx.lifecycle.MutableLiveData
import api.APIResponse


interface BaseSignup {
    fun signup(username: String,password: String,email:String,phone:String,response:MutableLiveData<APIResponse>)
    fun deleteAccount()
}