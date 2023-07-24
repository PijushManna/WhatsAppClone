package com.example.signup.repo

import api.ApiResponse
import com.example.signup.base.LoginService

class LoginRepo(private val loginService: LoginService) {
    suspend fun login(email: String, password: String): ApiResponse = loginService.login(email, password)

    suspend fun logout():ApiResponse = loginService.logout()

    fun isLoggedIn():Boolean = loginService.isLoggedIn()

    suspend fun signUp(
        username: String,
        password: String,
        email: String,
        phone: String,
        about:String,
        imageUrl:String
    ):ApiResponse = loginService.signUp(username, password, email, phone,about,imageUrl)
}