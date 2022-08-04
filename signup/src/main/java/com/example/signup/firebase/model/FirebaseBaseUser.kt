package com.example.signup.firebase.model

import android.net.Uri
import com.example.signup.base.interfaces.BaseUser
import com.example.signup.firebase.utils.FirebaseConstants.DB_IS_USER_ONLINE
import com.example.signup.firebase.utils.FirebaseConstants.DB_USERS
import com.example.signup.firebase.utils.FirebaseConstants.DB_USERS_ONLINE
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue

class FirebaseBaseUser(
    override val uid: String?,
    override val photoUrl: Uri?,
    override val displayName: String?,
    override val email: String?,
    override val phoneNumber: String?,
    override val online: String?,
    override val status: String?,
    override val deviceToken: String?
) : BaseUser {
    private val dbReference by lazy { uid?.let {
        FirebaseDatabase.getInstance().reference.child(DB_USERS).child(
            it
        )
    } }

    override fun isConnected() {
        dbReference?.apply{child(DB_USERS_ONLINE).setValue(DB_IS_USER_ONLINE)}
    }

    override fun isDisconnected() {
        dbReference?.apply{child(DB_USERS_ONLINE).setValue(ServerValue.TIMESTAMP)}
    }

}
