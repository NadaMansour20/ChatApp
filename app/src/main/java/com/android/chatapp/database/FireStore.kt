package com.android.chatapp.database

import com.android.chatapp.model.AppUser
import com.android.chatapp.model.Message
import com.android.chatapp.model.Room
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


fun getCollection(CollectionName: String): CollectionReference {
    val firestore = Firebase.firestore

    //create collection
    return firestore.collection(CollectionName)

}


//register
fun addUserToFirestore(
    user: AppUser,
    onSuccessListener: OnSuccessListener<Void>,
    onFailureListener: OnFailureListener
) {

    val collection = getCollection(AppUser.CollectionNameAppUser)

    //just document ,firebase that is enter id
    //document() , I am who entered the id
    val document = collection.document(user.id!!)

    //new document --> new object
    document.set(user).addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)


}

// login
fun signInToFirebase(
    id: String,
    onSuccessListener: OnSuccessListener<DocumentSnapshot>,
    onFailureListener: OnFailureListener
) {

    val collection = getCollection(AppUser.CollectionNameAppUser)
    val document = collection.document(id)

    document.get().addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener)
}

fun add_Room(
    room: Room,
    onSuccessListener: OnSuccessListener<Void>,
    onFailureListener: OnFailureListener
) {
    val collection = getCollection(Room.collection_nameRoom)
    val document = collection.document()

    room.id = document.id
    document.set(room).addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)


}

fun get_Room(
    onSuccessListener: OnSuccessListener<QuerySnapshot>,
    onFailureListener: OnFailureListener
) {

    val collecttion = getCollection(Room.collection_nameRoom)

    collecttion.get().addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)

}

fun get_message_Ref(room_id: String): CollectionReference {
    val collectionRef = getCollection(Room.collection_nameRoom)
    val roomRef = collectionRef.document(room_id)
    return roomRef.collection(Message.CollectionNameMessage)
}

fun save_message(
    message: Message,
    onSuccessListener: OnSuccessListener<Void>,
    onFailureListener: OnFailureListener
) {

    val message_collRef = get_message_Ref(message.room_id!!)
    val document = message_collRef.document()

    message.id = document.id
    document.set(message).addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)


}


