package com.example.joaovictor_dr3_at

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentChange
import java.lang.Exception

class ChatViewModel : ViewModel() {

    private val _chat = MutableLiveData<List<Chat>>()
    val chat: LiveData<List<Chat>> = _chat

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    init {
        updateChat()
    }

    private fun updateChat() {
        ChatDao
            .list()
            .addSnapshotListener { snapshot, error ->
                if (snapshot != null && !snapshot.isEmpty) {
//                    for (documentChanged in snapshot.documentChanges){
//                        when (documentChanged.type){
//                            DocumentChange.Type.ADDED -> Log.d("DocumentChange", "Added: ${documentChanged.document.id}")
//                            DocumentChange.Type.MODIFIED -> Log.d("DocumentChange", "Modified: ${documentChanged.document.id}")
//                            DocumentChange.Type.REMOVED -> Log.d("DocumentChange", "Removed: ${documentChanged.document.id}")
//                        }
//                    }
                    _chat.value = snapshot.toObjects(Chat::class.java)
                } else if (error != null)
                    _message.value = error.message
                else
                    _message.value = "Nenhuma mensagem!"
            }
    }

    fun insert(userInputMessage: String) {
        ChatDao
            .insert(Chat(userInputMessage, "j@v"))
//        updateChat()
    }

    fun deleteMessage(messagePosition: Int) {
        try {
            val chat = _chat.value!!.get(messagePosition)
            ChatDao.delete(chat)
        } catch (e: Exception) {
            _message.value = e.message
        }
    }
}