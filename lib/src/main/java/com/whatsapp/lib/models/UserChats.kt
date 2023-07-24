package com.whatsapp.lib.models

data class UserChats(
    val id:String,
    val senderId:String,
    val recipientId:String,
    val chatId:String,
    var isForwarded:Boolean
)
