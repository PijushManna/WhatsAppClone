package com.blogspot.whatsappclone.ui.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.whatsappclone.R
import com.blogspot.whatsappclone.components.DaggerUserLoginComponents
import com.blogspot.whatsappclone.ui.activity.login.LoginActivity
import com.blogspot.whatsappclone.ui.activity.main.MainActivity
import com.example.signup.base.services.BaseUserLoginService
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var login:BaseUserLoginService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        DaggerUserLoginComponents.builder().build().inject(this)
    }

    override fun onStart() {
        super.onStart()
        addLoggedInListener()
    }

    private fun addLoggedInListener() {
        if (login.isLoggedIn()){
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}