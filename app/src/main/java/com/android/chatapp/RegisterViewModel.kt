package com.android.chatapp

import android.util.Log
import androidx.databinding.ObservableField
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegisterViewModel : BaseViewModel() {
    val first_name = ObservableField<String>("")
    val first_nameError = ObservableField<String>("")

    val last_name = ObservableField<String>("")
    val last_nameError = ObservableField<String>("")

    val email = ObservableField<String>("")
    val emailError = ObservableField<String>("")

    val password = ObservableField<String>("")
    val passwordError = ObservableField<String>("")


    private var auth: FirebaseAuth = Firebase.auth


    fun add_account() {
        if (validate()) {
            creatAccountToFirebase()

        }
    }

    private fun creatAccountToFirebase() {

        show_load_LiveData.value = true
        auth.createUserWithEmailAndPassword(email.get()!!, password.get()!!)
            .addOnCompleteListener { task ->

                show_load_LiveData.value = false

                if (!task.isSuccessful) {
                    massegeLiveData.value = "failed registration"
                    Log.e("firebase", "failed" + task.exception?.localizedMessage)
                } else {
                    massegeLiveData.value = "successfully registration"
                    Log.e("firebase", "success registration")

                }
            }
    }

    fun validate(): Boolean {
        var flag = true
        if (first_name.get().isNullOrBlank()) {
            first_nameError.set("Please enter first_name")
            flag = false
        } else {
            first_nameError.set(null)
        }
        if (last_name.get().isNullOrBlank()) {
            last_nameError.set("Please enter last_name")
            flag = false
        } else {
            last_nameError.set(null)
        }
        if (email.get().isNullOrBlank()) {
            emailError.set("Please enter email")
            flag = false
        } else {
            emailError.set(null)
        }
        if (password.get().isNullOrBlank()) {
            passwordError.set("Please enter password")
            flag = false
        } else {
            passwordError.set(null)
        }
        return flag
    }
}