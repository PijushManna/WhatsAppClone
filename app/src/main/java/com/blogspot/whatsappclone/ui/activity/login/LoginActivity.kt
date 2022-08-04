package com.blogspot.whatsappclone.ui.activity.login

import android.os.Bundle
import androidx.lifecycle.Observer
import com.blogspot.whatsappclone.components.DaggerUserLoginComponents
import com.blogspot.whatsappclone.databinding.ActivityLoginBinding
import com.blogspot.whatsappclone.ui.activity.base.BaseActivity
import com.blogspot.whatsappclone.ui.activity.login.viewmodel.LoginViewModel
import com.blogspot.whatsappclone.utils.InjectorUtils
import com.example.signup.base.services.BaseUserLoginService
import utils.toast
import javax.inject.Inject

class LoginActivity : BaseActivity() {
    @Inject
    lateinit var loginService: BaseUserLoginService
    private val loginViewModel: LoginViewModel by lazy { InjectorUtils.getLoginViewModel(this,loginService)}
    private val binding:ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerUserLoginComponents.builder().build().inject(this)
        setContentView(binding.root)
        binding.viewModel = loginViewModel
        addObservers()
        addOnClickListener()
    }

    private fun addOnClickListener() {
    }

    private fun addObservers() {
        loginViewModel.apply {
            email.observe(this@LoginActivity,emailObserver)
            password.observe(this@LoginActivity,passwordObserver)
            response.observe(this@LoginActivity,apiResponseObserver)
        }
    }

    private val emailObserver:Observer<String> = Observer<String>{
        binding.btnLogin.isEnabled = !it.isNullOrBlank()
    }

    private val passwordObserver:Observer<String> = Observer<String>{
        binding.btnLogin.isEnabled = !it.isNullOrBlank()
    }

    override fun onAPISuccess() {
        toast("User logged in ")
    }
}