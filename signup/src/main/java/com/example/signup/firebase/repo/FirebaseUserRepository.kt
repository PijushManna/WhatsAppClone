package com.example.signup.firebase.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import api.APIResponse
import com.example.signup.base.interfaces.BaseUserRepository
import com.example.signup.firebase.utils.FirebaseConstants.TAG

class FirebaseUserRepository : BaseUserRepository {
    override fun signUp(
        username: String?,
        password: String?,
        email: String?,
        phone: String?,
        response: MutableLiveData<APIResponse>
    ) {
        Log.i(TAG, "signUp: Firebase")
    }

    override fun deleteAccount() {
        Log.i(TAG, "delete account")
    }
}