package com.example.signup.firebase.service

import androidx.lifecycle.MutableLiveData
import api.APIResponse
import com.example.signup.base.interfaces.BaseLogin
import com.google.firebase.auth.FirebaseAuth


class FirebaseLogin(private val firebaseInstance:FirebaseAuth) : BaseLogin {
    override fun login(email: String, password: String,response: MutableLiveData<APIResponse>) {
        response.value = APIResponse.InProgress
        firebaseInstance.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                response.postValue(APIResponse.Success())
            }
            if (it.exception!=null){
                response.postValue(APIResponse.Error(it.exception))
            }
        }
    }

    override fun logout() {
        firebaseInstance.signOut()
    }

    override fun isLoggedIn(): Boolean {
        return firebaseInstance.currentUser != null
    }
}