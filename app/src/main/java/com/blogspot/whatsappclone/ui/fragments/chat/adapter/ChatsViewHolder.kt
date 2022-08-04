package com.blogspot.whatsappclone.ui.fragments.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.blogspot.whatsappclone.database.models.Chats
import com.blogspot.whatsappclone.databinding.ListItemChatRequestsBinding
import recyclerview.BaseModel
import recyclerview.BaseViewHolder

class ChatsViewHolder(private val binding:ListItemChatRequestsBinding) : BaseViewHolder(binding.root) {
    override fun bind(item: BaseModel) {
        item as Chats
        binding.apply {
            model = item
            executePendingBindings()
        }
    }

    override fun from(parent: ViewGroup): BaseViewHolder {
        return ChatsViewHolder(ListItemChatRequestsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}