package com.blogspot.whatsappclone.database.test

import com.blogspot.whatsappclone.database.models.Chats

object TestData {
    val chatsList by lazy {arrayListOf(
        Chats(1,1,"Ankit","Hello how are you","https://picsum.photos/200",System.currentTimeMillis()),
        Chats(2,2,"Ram","Hello how are you","https://picsum.photos/200",System.currentTimeMillis()),
        Chats(3,3,"Shayam","Hello how are you","https://picsum.photos/200",System.currentTimeMillis()),
    )}
}