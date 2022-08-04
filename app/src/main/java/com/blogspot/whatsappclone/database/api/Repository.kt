package com.blogspot.whatsappclone.database.api

import com.blogspot.whatsappclone.database.models.Chats
import com.blogspot.whatsappclone.database.test.TestData
import com.blogspot.whatsappclone.utils.Constants

object Repository {
    fun getChats(): List<Chats> {
        if (Constants.IS_DUMMY_APP){
            return TestData.chatsList
        }
        return arrayListOf()
    }
}