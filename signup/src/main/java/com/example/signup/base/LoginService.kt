package com.example.signup.base

import api.ApiResponse
import com.example.signup.models.User

interface LoginService {
    suspend fun login(email: String, password:String):ApiResponse
    suspend fun logout():ApiResponse
    fun isLoggedIn():Boolean
    suspend fun signUp(username: String, password: String, email: String, phone: String, about:String, imageUrl:String):ApiResponse
    fun getCurrentUser():User?
}