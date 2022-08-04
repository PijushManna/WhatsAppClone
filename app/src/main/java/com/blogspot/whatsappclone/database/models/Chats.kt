package com.blogspot.whatsappclone.database.models

import recyclerview.BaseModel


data class Chats(
    override val id: Long,
    val uid: Long,
    val username: String,
    val lastMessage: String,
    val profileImgUrl: String,
    val updatedAt: Long
) : BaseModel