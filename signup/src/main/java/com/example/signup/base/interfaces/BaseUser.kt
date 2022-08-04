package com.example.signup.base.interfaces

import android.net.Uri

public interface BaseUser {
    val uid: String?
    val photoUrl: Uri?
    val displayName: String?
    val email: String?
    val phoneNumber: String?
    val online: String?
    val status: String?
    val deviceToken: String?
    fun logOut()
    fun isConnected()
    fun isDisconnected()
}
