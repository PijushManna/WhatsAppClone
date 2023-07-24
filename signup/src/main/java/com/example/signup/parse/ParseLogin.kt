package com.example.signup.parse

import api.ApiResponse
import com.example.signup.base.LoginService
import com.example.signup.models.User
import com.example.signup.util.SignUpConstants
import com.example.signup.util.SignUpConstants.PHONE
import com.example.signup.verification.SignupVerifier
import com.parse.ParseUser
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class ParseLogin() : LoginService {

    override suspend fun login(email: String, password: String): ApiResponse {
        return suspendCoroutine {
            if (SignupVerifier.isUsernameValid(email) && SignupVerifier.isPasswordValid(password)) {
                ParseUser.logInInBackground(email, password) { user, e ->
                    if (user != null) {
                        it.resume(ApiResponse.Success(user))
                    } else {
                        it.resume(ApiResponse.Error(e))
                    }
                }
            } else{
                it.resume(ApiResponse.Error((Exception("Username or Password is not valid"))))
            }
        }
    }
    override suspend fun logout():ApiResponse {
        return suspendCoroutine { continuation ->
            ParseUser.logOutInBackground {
                if (it == null){
                    continuation.resume(ApiResponse.Success())
                }else{
                    continuation.resume(ApiResponse.Error(it))
                }
            }
        }
    }

    override fun isLoggedIn(): Boolean {
        return ParseUser.getCurrentUser() != null
    }

    override suspend fun signUp(
        username: String,
        password: String,
        email: String,
        phone: String,
        about: String,
        imageUrl: String
    ): ApiResponse {
        return suspendCoroutine { continuation ->
            val user = ParseUser()
            user.username = username;
            user.setPassword(password);
            user.email = email;
            user.put(PHONE,phone)
            user.signUpInBackground { e ->
                if (e == null) {
                    continuation.resume(ApiResponse.Success())
                } else {
                    continuation.resume(ApiResponse.Error(e))
                }
            }
        }
    }

    override fun getCurrentUser(): User? {
       return ParseUser.getCurrentUser()?.let{
            User(it.objectId,it.username, phoneNumber = it.getString(PHONE),about = it.getString(SignUpConstants.ABOUT), imageUrl = it.getString(SignUpConstants.IMAGE_URL))
        }
    }
}