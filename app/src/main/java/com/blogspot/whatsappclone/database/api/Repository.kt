package com.blogspot.whatsappclone.database.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blogspot.whatsappclone.database.models.Chats
import com.blogspot.whatsappclone.database.models.ServerMsg
import com.blogspot.whatsappclone.database.test.TestData
import com.blogspot.whatsappclone.utils.Constants
import com.blogspot.whatsappclone.utils.InjectorUtils
import com.example.signup.firebase.utils.FirebaseConstants
import com.example.signup.firebase.utils.FirebaseConstants.TAG
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

object Repository {
    fun getChats(): LiveData<List<Chats>> {
        val data = MutableLiveData<List<Chats>>()
        if (Constants.IS_DUMMY_APP){
            data.value = TestData.chatsList
            return data
        }

        val currentUser = InjectorUtils.currentUser
        val dbReference = InjectorUtils.dbReference.child(FirebaseConstants.DB_MESSAGES).child(currentUser!!.uid)
        dbReference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val msgs = snapshot.value as ArrayList<ServerMsg>
                Log.i(TAG, "onDataChange: $msgs")

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        return data
    }
}