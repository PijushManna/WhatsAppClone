package com.blogspot.whatsappclone.ui.activity.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import api.APIResponse
import com.blogspot.whatsappclone.R
import com.blogspot.whatsappclone.utils.InjectorUtils.dbReference
import com.blogspot.whatsappclone.utils.InjectorUtils.firebaseAuth
import com.example.signup.firebase.service.FirebaseSignup
import com.example.signup.firebase.utils.FirebaseConstants
import utils.toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val signup = FirebaseSignup(firebaseAuth,dbReference.child(FirebaseConstants.DB_USERS))
        val response = MutableLiveData<APIResponse>()
        signup.signup("pijush","pijush","pijush@gmail.com","123456",response)

        response.observe(this){
            toast(it.toString())
        }
    }
}