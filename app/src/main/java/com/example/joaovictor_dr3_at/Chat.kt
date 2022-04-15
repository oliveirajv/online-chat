package com.example.joaovictor_dr3_at

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.Timestamp
import java.text.SimpleDateFormat

class Chat(
    val message: String = "",
    val user: String = "",
    val date: Timestamp = Timestamp.now(),
    @DocumentId val id: String? = null,
//    val order: Int = 0,
) {
    override fun toString(): String {
        val simpleDateFormat = SimpleDateFormat("dd/MM/yy HH:mm")
        val date = simpleDateFormat.format(date.toDate())
        return "$user [${date}]: $message"
    }
}

object ChatDao {
    private val collection = Firebase
        .firestore
        .collection("chat")

    //A baixo todas as funções do CRUD do Firebase.

    //Inserir.
    fun insert(chat: Chat): Task<DocumentReference> {
        return collection.add(chat)
    }

    fun list(): Query {
        return collection
            .orderBy("date")
    }

    //Ler.
    fun read(chat: Chat): Task<DocumentSnapshot> {
        return collection
            .document(chat.id!!)
            .get()
    }

    //Atualizar.
    fun update(chat: Chat): Task<Void> {
        return collection
            .document(chat.id!!)
            .set(chat, SetOptions.merge()) //Substituir o documento {message, user, order}
    }

    //Deletar.
    fun delete(chat: Chat): Task<Void> {
        return collection.document(chat.id!!).delete()
    }

    //Listando por limite e ordem.
    fun listLimitedAndOrdered(): Task<QuerySnapshot> {
        return collection
            .orderBy("order", Query.Direction.DESCENDING)
            .startAt(2)
            .endBefore(3)
            .limit(2)
            .get()
    }

    //Listar por limite.
    fun listLimited(): Task<QuerySnapshot> {
        return collection
            .limit(2)
            .get()
    }

    //Listando por filtro e ordem.
    fun listFilteredAndOrdered(): Task<QuerySnapshot> {
        return collection
            .whereGreaterThan("user", "j@v") // j, k, l, m...
            .orderBy("user")
//            .whereGreaterThanOrEqualTo("order", 2)
            .orderBy("order")
            .get()
    }

    //Listar por ordem.
    fun listOrdered(): Task<QuerySnapshot> {
        return collection
            .orderBy("order", Query.Direction.DESCENDING)
            .get()
    }

    //Listar por filtro.
    fun listFiltered(): Task<QuerySnapshot> {
        return collection
//            .whereEqualTo("user", "j@v") //Filtro.
            .whereIn("user", mutableListOf("j@v", "user"))
//            .whereGreaterThan("ordem", 2)
            .get()
    }
}
