package com.blogspot.whatsappclone.ui.fragments.chat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blogspot.whatsappclone.database.api.Repository
import com.blogspot.whatsappclone.database.models.Chats

class ChatsViewModel(private val repository: Repository) : ViewModel() {
    private val _allChats = MutableLiveData<List<Chats>>()
    val allChats: LiveData<List<Chats>> = repository.getChats()

    init {

    }


    class ChatsViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ChatsViewModel(repository) as T
        }
    }
}