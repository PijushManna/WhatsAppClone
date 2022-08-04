package com.example.signup.firebase.service

import android.util.Log
import androidx.lifecycle.MutableLiveData
import api.APIResponse
import com.example.signup.base.interfaces.BaseLogin
import com.example.signup.firebase.utils.FirebaseConstants
import com.google.firebase.auth.FirebaseAuth

class FirebaseLogin : BaseLogin {
    private val firebaseInstance = FirebaseAuth.getInstance()
    override fun login(email: String, password: String,response: MutableLiveData<APIResponse>) {

        response.value = APIResponse.InProgress
        Log.i(FirebaseConstants.TAG,"Login in progress")
        firebaseInstance.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                response.postValue(APIResponse.Success(it.result))
                Log.i(FirebaseConstants.TAG,"Login in done")
            }
            if (it.exception!=null){
                response.postValue(APIResponse.Error(it.exception))
                Log.i(FirebaseConstants.TAG,"Login failed ${it.exception!!.message}")
            }
        }
    }

    override fun logout() {
        firebaseInstance.signOut()
    }

    override fun isLoggedIn(): Boolean {
        Log.i(FirebaseConstants.TAG,firebaseInstance.currentUser.toString())
        return firebaseInstance.currentUser != null
    }


}