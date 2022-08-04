package com.example.signup.firebase.model

import android.net.Uri
import com.example.signup.base.interfaces.BaseUser
import com.example.signup.firebase.utils.FirebaseConstants.DB_IS_USER_ONLINE
import com.example.signup.firebase.utils.FirebaseConstants.DB_USERS
import com.example.signup.firebase.utils.FirebaseConstants.DB_USERS_ONLINE
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue

class FirebaseBaseUser(private val currentUser: FirebaseUser?,private val mAuth: FirebaseAuth) : BaseUser {
    private val dbReference by lazy { uid?.let {
        FirebaseDatabase.getInstance().reference.child(DB_USERS).child(
            it
        )
    } }

    override val uid: String?
        get() = currentUser?.uid
    override val photoUrl: Uri?
        get() = currentUser?.photoUrl
    override val displayName: String?
        get() = currentUser?.displayName
    override val email: String?
        get() = currentUser?.email
    override val phoneNumber: String?
        get() = currentUser?.phoneNumber
    override val online: String?
        get() = "true"
    override val status: String?
        get() = "Hey there I am using WhatsAppClone"
    override val deviceToken: String?
        get() = ""

    override fun logOut() {
        dbReference?.apply {
            child(DB_USERS_ONLINE).removeValue().addOnCompleteListener {
                if (it.isSuccessful) {
                    mAuth.signOut()
                }
            }
        }
    }

    override fun isConnected() {
        dbReference?.apply{child(DB_USERS_ONLINE).setValue(DB_IS_USER_ONLINE)}
    }

    override fun isDisconnected() {
        dbReference?.apply{child(DB_USERS_ONLINE).setValue(ServerValue.TIMESTAMP)}
    }

}
