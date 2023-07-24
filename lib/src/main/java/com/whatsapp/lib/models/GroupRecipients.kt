package com.whatsapp.lib.models

data class GroupRecipients(
    val id:String,
    val groupId:String,
    var userid:String,
    var isAdmin:Boolean
)