package com.example.signup.parse.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import api.APIResponse
import com.example.signup.base.interfaces.BaseUserRepository

private const val TAG = "ParseUserRegistration"
class ParseUserRepository : BaseUserRepository {
    override fun signUp(
        username: String?,
        password: String?,
        email: String?,
        phone: String?,
        response: MutableLiveData<APIResponse>
    ) {
        Log.i(TAG, "signUp: Parse")
    }

    override fun deleteAccount() {
        Log.i(TAG, "delete account")
    }
}