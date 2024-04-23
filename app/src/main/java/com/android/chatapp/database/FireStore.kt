package com.android.chatapp.database

import com.android.chatapp.model.AppUser
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

    val collection = getCollection(AppUser.CollectionName)

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

    val collection = getCollection(AppUser.CollectionName)
    val document = collection.document(id)

    document.get().addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener)
}

fun add_Room(
    room: Room,
    onSuccessListener: OnSuccessListener<Void>,
    onFailureListener: OnFailureListener
) {
    val collection = getCollection(Room.collection_name)
    val document = collection.document()

    room.id = document.id
    document.set(room).addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)


}

fun get_Room(
    onSuccessListener: OnSuccessListener<QuerySnapshot>,
    onFailureListener: OnFailureListener
) {

    val collecttion = getCollection(Room.collection_name)

    collecttion.get().addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)

}