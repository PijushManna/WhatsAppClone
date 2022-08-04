package com.example.signup.parse

import android.content.Context
import com.example.signup.parse.service.ParseLogin
import com.parse.Parse


object ParseFactory {
    private const val APP_ID = "0yvkCAZLiV0Qq2kN7KqBImsWymGEASg82R0B4Z4T"
    private const val CLIENT_KEY = "m2xHOTSgb0WqfwWToq1Avje7FW9SPNU5NR3O7YFV"
    private const val SERVER_URL = "https://parseapi.back4app.com/"

    private var isParseInitialized = false
    private val parseSignup: ParseSignup by lazy { ParseSignup() }
    private val mParseLogin: ParseLogin by lazy { ParseLogin() }

    private fun initParse(context: Context){
        Parse.initialize(
            Parse.Configuration.Builder(context.applicationContext)
                .applicationId(APP_ID)
                .clientKey(CLIENT_KEY)
                .server(SERVER_URL)
                .build()
        )
        isParseInitialized = true
    }

    fun getParseSignUp(context: Context): ParseSignup {
        if (!isParseInitialized){
            initParse(context)
        }
        return parseSignup
    }

    fun getParseLogin(): ParseLogin {
        return mParseLogin
    }
}