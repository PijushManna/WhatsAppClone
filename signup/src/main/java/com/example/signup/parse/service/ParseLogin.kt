package com.example.signup.parse.service

import androidx.lifecycle.MutableLiveData
import api.APIResponse
import com.example.signup.base.interfaces.BaseLogin
import com.example.signup.verification.SignupVerifier
import com.parse.ParseUser


class ParseLogin() : BaseLogin {

    override fun login(email: String, password: String, response:MutableLiveData<APIResponse>) {
        if (SignupVerifier.isUsernameValid(email) && SignupVerifier.isPasswordValid(password)) {
            response.value = APIResponse.InProgress
            ParseUser.logInInBackground(email, password) { user, e ->
                if (user != null) {
                    response.postValue(APIResponse.Success(user.username))
                } else {
                    response.postValue(APIResponse.Error(e))
                }
            }
        }
    }
    override fun logout() {
       ParseUser.logOut()
    }

    override fun isLoggedIn(): Boolean {
        return ParseUser.getCurrentUser() != null
    }
}