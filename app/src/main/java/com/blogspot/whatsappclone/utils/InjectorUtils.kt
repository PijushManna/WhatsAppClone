package com.blogspot.whatsappclone.utils

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.blogspot.whatsappclone.database.api.Repository
import com.blogspot.whatsappclone.databinding.ListItemChatRequestsBinding
import com.blogspot.whatsappclone.ui.activity.login.viewmodel.LoginViewModel
import com.blogspot.whatsappclone.ui.fragments.chat.adapter.ChatsViewHolder
import com.blogspot.whatsappclone.ui.fragments.chat.viewmodel.ChatsViewModel
import com.example.signup.base.services.BaseUserLoginService
import recyclerview.BaseRecyclerAdapter

object InjectorUtils {
    fun getChatsViewModel(owner: ViewModelStoreOwner): ChatsViewModel {
        return ViewModelProvider(owner,ChatsViewModel.ChatsViewModelFactory(getRepository()))[ChatsViewModel::class.java]
    }

    private fun getRepository():Repository{
        return Repository
    }

    fun getChatsAdapter(inflater: LayoutInflater): BaseRecyclerAdapter {
       return BaseRecyclerAdapter(ChatsViewHolder(ListItemChatRequestsBinding.inflate(inflater)))
    }

    fun getLoginViewModel(owner: ViewModelStoreOwner,loginService: BaseUserLoginService): LoginViewModel {
        return ViewModelProvider(owner,LoginViewModel.LoginViewModelFactory(loginService))[LoginViewModel::class.java]
    }
}