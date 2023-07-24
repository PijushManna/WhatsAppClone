package com.whatsapp.lib.api

import com.whatsapp.lib.models.UserChats
import com.whatsapp.lib.models.UserGroups
import java.util.UUID

class ChatsRepo {
    fun getAllUserChats(userId:String):List<UserChats>{
        //TODO : not yet implemented
        return arrayListOf()
    }

    fun getAllUserGroups(userId: String):List<UserGroups>{
        return arrayListOf()
    }

    fun sendMessage(userID: String, channelID: String, message: String): Boolean{
        return false
    }

    fun joinGroup(userID: String, channelID: String): Boolean{
        return false
    }

    fun leaveGroup(userID: String, channelID: String): Boolean{
        return false
    }
}