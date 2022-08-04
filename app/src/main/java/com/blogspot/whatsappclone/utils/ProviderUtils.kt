package com.blogspot.whatsappclone.utils

import com.blogspot.whatsappclone.ui.fragments.chat.ChatsFragment
import com.blogspot.whatsappclone.ui.fragments.contacts.ContactsFragment
import com.blogspot.whatsappclone.ui.fragments.status.StatusFragment
import com.example.signup.base.interfaces.BaseUser
import com.example.signup.firebase.model.FirebaseBaseUser
import com.google.firebase.auth.FirebaseAuth
import fragments.base.BaseFragment

object ProviderUtils {
    fun getFragmentsList():List<BaseFragment>{
        return arrayListOf(
            ChatsFragment(),
            StatusFragment(),
            ContactsFragment()
        )
    }

    fun getCurrentUser(): BaseUser? {
        return FirebaseAuth.getInstance().currentUser?.let { FirebaseBaseUser(it,FirebaseAuth.getInstance()) }
    }
}