package com.android.chatapp.ui.login

import android.util.Log
import androidx.databinding.ObservableField
import com.android.chatapp.base.BaseViewModel
import com.android.chatapp.database.signInToFirebase
import com.android.chatapp.model.AppUser
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginViewModel : BaseViewModel<Navigator>() {

    val email = ObservableField<String>("")
    val emailError = ObservableField<String>("")

    val password = ObservableField<String>("")
    val passwordError = ObservableField<String>("")


    private var auth: FirebaseAuth = Firebase.auth
    fun login() {
        if (validate()) {
            loginAccount()
        }

    }

    fun open_register() {
        navigator?.openRegisterActivity()
    }


    //create authentication login
    private fun loginAccount() {

        show_load_LiveData.value = true
        auth.signInWithEmailAndPassword(email.get()!!, password.get()!!)
            .addOnCompleteListener { task ->

                show_load_LiveData.value = false

                if (!task.isSuccessful) {
                    massegeLiveData.value = "failed login"
                    Log.e("firebase", "failed" + task.exception?.localizedMessage)
                } else {
                    massegeLiveData.value = "successfully login"
                    Log.e("firebase", "successful login")

                    checkAccountInFiresote(task.result.user?.uid)

                }
            }
    }


    //check if user found in fire store(database) before or not to can login success
    private fun checkAccountInFiresote(uid: String?) {

        signInToFirebase(uid!!, {

            //(OnSuccessListener)
            // to object() convert return data -> (document) to appUser object
            val user = it.toObject(AppUser::class.java)
            if (user == null) {
                massegeLiveData.value = "Invalid email or Password"
                return@signInToFirebase
            } else {
                navigator?.openHomeActivity()
            }

        }, {

            //(OnFailureListener)
            massegeLiveData.value = it.localizedMessage

        })

    }


    fun validate(): Boolean {
        var flag = true

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