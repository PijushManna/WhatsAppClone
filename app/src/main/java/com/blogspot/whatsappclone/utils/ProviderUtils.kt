package com.blogspot.whatsappclone.utils

import com.blogspot.whatsappclone.ui.fragments.chat.ChatsFragment
import com.blogspot.whatsappclone.ui.fragments.contacts.ContactsFragment
import com.blogspot.whatsappclone.ui.fragments.status.StatusFragment
import fragments.base.BaseFragment

object ProviderUtils {
    fun getFragmentsList():List<BaseFragment>{
        return arrayListOf(
            ChatsFragment(),
            StatusFragment(),
            ContactsFragment()
        )
    }
}