package com.blogspot.whatsappclone.components

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

const val CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE"
@Deprecated("Not used now")
class ConnectivityReceiver : BroadcastReceiver() {
//    private val user = InjectorUtils.loginService
    override fun onReceive(context: Context?, intent: Intent) {
        val action = intent.action
        if (CONNECTIVITY_CHANGE_ACTION == action) {
            if(isUserConnected(context!!)){
//                user?.isConnected()
            }else{
//                user?.isDisconnected()
            }
        }
    }

    private fun isUserConnected(context: Context): Boolean {
        val isConnected: Boolean
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            isConnected = when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            isConnected = when (connectivityManager.activeNetworkInfo?.type) {
                ConnectivityManager.TYPE_WIFI -> true
                ConnectivityManager.TYPE_MOBILE -> true
                ConnectivityManager.TYPE_ETHERNET -> true
                else -> false
            }
        }
        return isConnected
    }
}
/**
<!--        <receiver-->
<!--            android:name=".components.ConnectivityReceiver"-->
<!--            android:exported="true"-->
<!--            android:enabled="true">-->
<!--            <intent-filter>-->
<!--                <action android:name="android.net.conn.CONNECTIVITY_CHANGE"-->
<!--                    tools:ignore="BatteryLife" />-->
<!--            </intent-filter>-->
<!--        </receiver>--> */