package com.android.chatapp.database

import com.android.chatapp.model.AppUser
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


fun getCollection(CollectionName: String): CollectionReference {
    val firestore = Firebase.firestore

    return firestore.collection(CollectionName)

}

fun addUserToFirestore(
    user: AppUser,
    onSuccessListener: OnSuccessListener<Void>,
    onFailureListener: OnFailureListener
) {

    val collection = getCollection(AppUser.CollectionName)

    //just document ,firebase that is enter id
    //document() , I am who entered the id
    val document = collection.document(user.id!!)

    document.set(user).addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)


}

fun signInToFirebase(
    id: String,
    onSuccessListener: OnSuccessListener<DocumentSnapshot>,
    onFailureListener: OnFailureListener
) {

    val collection = getCollection(AppUser.CollectionName)
    val document = collection.document(id)

    document.get().addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener)
}