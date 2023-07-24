package com.example.signup.models

data class User(
    val id:String,
    var name:String,
    var phoneNumber:String?,
    var about:String?,
    var imageUrl:String?
)
