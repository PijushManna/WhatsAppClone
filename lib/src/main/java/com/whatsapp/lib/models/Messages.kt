package com.whatsapp.lib.models

data class Messages(
    val id: String,
    val userId: String,
    val chatId: String,
    val groupId: String?,
    var type: String,
    var content: String,
    var sendAt: Long,
    var deliveredAt: Long?,
    var seenAt: Long?
)