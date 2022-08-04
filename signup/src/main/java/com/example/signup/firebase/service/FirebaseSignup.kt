package com.example.signup.firebase.service

import androidx.lifecycle.MutableLiveData
import api.APIResponse
import com.example.signup.base.interfaces.BaseSignup
import com.example.signup.firebase.model.FirebaseBaseUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class FirebaseSignup(private val mAuth: FirebaseAuth, private val dbReference: DatabaseReference) :
    BaseSignup {
    override fun signup(
        username: String,
        password: String,
        email: String,
        phone: String,
        response: MutableLiveData<APIResponse>
    ) {
        response.value = APIResponse.InProgress
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                response.value = APIResponse.Success()
                mAuth.currentUser?.let { it1 ->
                    val newUser = FirebaseBaseUser(
                        uid = it1.uid,
                        photoUrl = it1.photoUrl,
                        displayName = it1.displayName,
                        email = email,
                        phoneNumber = phone,
                        online = "true",
                        status = "Hey there I am using What'sApp",
                        deviceToken = ""
                    )
                    createUserAccountInDb(newUser)
                }
            }
            if (it.exception != null) {
                response.value = APIResponse.Error(it.exception)
            }
        }
    }

    private fun createUserAccountInDb(user:FirebaseBaseUser){
        if(user.uid!=null) {
            dbReference.child(user.uid).setValue(user)
        }
    }

    override fun deleteAccount() {
        TODO("Not yet implemented")
    }
}