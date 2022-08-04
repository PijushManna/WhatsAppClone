package com.example.signup.parse

import androidx.lifecycle.MutableLiveData
import api.APIResponse
import com.example.signup.base.BaseSignUp
import com.example.signup.base.interfaces.BaseSignup
import com.parse.ParseUser


class ParseSignup :BaseSignUp(), BaseSignup {
    override fun signupAnonymously() {
        //TODO : Not yet implemented
    }

    override fun signup(username: String?, password: String?, email: String?, phone: String?, response: MutableLiveData<APIResponse>) {
        response.value = APIResponse.InProgress
        if (isValid(username, password, email,phone)) {
            val user = ParseUser()
            user.username = username;
            user.setPassword(password);
            user.email = email;
            phone?.also { user.put("phone",it) }
            user.signUpInBackground { e ->
                if (e == null) {
                    response.postValue(APIResponse.Success(null))
                } else {
                    response.postValue(APIResponse.Error(e))
                }
            }
        }else{
            response.value = APIResponse.Error(Exception("Invalid Credentials"))
        }
    }

    override fun deleteAccount() {
        TODO("Not yet implemented")
    }

}