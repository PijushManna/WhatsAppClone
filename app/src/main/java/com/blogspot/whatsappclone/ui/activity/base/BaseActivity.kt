package com.blogspot.whatsappclone.ui.activity.base

import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import api.APIResponse
import com.example.signup.firebase.utils.FirebaseConstants
import utils.toast

abstract class BaseActivity : AppCompatActivity(){
    protected val apiResponseObserver: Observer<APIResponse> = Observer<APIResponse> {
        Log.i(FirebaseConstants.TAG, "API Response: $it")
        when(it){
            is APIResponse.InProgress -> {toast("Loading")}
            is APIResponse.Success -> {onAPISuccess()}
            is APIResponse.Error -> {toast(it.exception!!.localizedMessage!!)}
        }
    }

    open fun onAPISuccess(){}

    fun showConfirmExit(){
        val builder = AlertDialog.Builder(this.applicationContext)
        builder.setMessage("Are you sure you want to exit ?")
        builder.setTitle("Exit")
        builder.setCancelable(false)
        builder.setPositiveButton("Ok") { _, _ -> finish() }
        builder.setNegativeButton("Cancel"){dialog,_ -> dialog.dismiss()}
        builder.show()
    }
}