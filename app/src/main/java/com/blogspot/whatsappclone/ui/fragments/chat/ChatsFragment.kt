package com.blogspot.whatsappclone.ui.fragments.chat


import com.blogspot.whatsappclone.databinding.FragmentChatsBinding
import com.blogspot.whatsappclone.ui.fragments.chat.viewmodel.ChatsViewModel
import com.blogspot.whatsappclone.utils.InjectorUtils
import fragments.base.BaseFragment

class ChatsFragment() : BaseFragment() {
    override val name: String = "CHATS"
    override val binding:FragmentChatsBinding by lazy{FragmentChatsBinding.inflate(layoutInflater)}
    private val chatsViewModel:ChatsViewModel by lazy { InjectorUtils.getChatsViewModel(this) }
    private val chatsAdapter by lazy { InjectorUtils.getChatsAdapter(layoutInflater)}

    override fun addObservers() {
       chatsViewModel.allChats.observe(this){
           chatsAdapter.submitList(it)
       }
    }

    override fun initViews() {
        binding.apply {
            rcrChatItems.adapter = chatsAdapter
        }
    }
}