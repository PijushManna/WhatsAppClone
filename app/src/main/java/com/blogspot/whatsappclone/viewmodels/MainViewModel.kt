package com.blogspot.whatsappclone.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.signup.base.interfaces.BaseUser

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var user: BaseUser? = null
}