package com.blogspot.whatsappclone.ui.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.whatsappclone.R
import com.blogspot.whatsappclone.ui.activity.login.LoginActivity
import com.blogspot.whatsappclone.ui.activity.main.MainActivity
import com.blogspot.whatsappclone.utils.InjectorUtils
import com.example.signup.base.interfaces.LoginService

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val login:LoginService = InjectorUtils.loginService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
//        startActivity(Intent(this, RegisterActivity::class.java))
        addLoggedInListener()
    }

    private fun addLoggedInListener() {
        if (login.isLoggedIn()){
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}