package com.blogspot.whatsappclone.ui.activity.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import api.ApiResponse
import com.blogspot.whatsappclone.R
import com.blogspot.whatsappclone.utils.InjectorUtils.dbReference
import com.blogspot.whatsappclone.utils.InjectorUtils.firebaseAuth
import utils.toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val signup =
        val response = MutableLiveData<ApiResponse>()
        signup.signup("pijush","pijush","pijush@gmail.com","123456",response)

        response.observe(this){
            toast(it.toString())
        }
    }
}