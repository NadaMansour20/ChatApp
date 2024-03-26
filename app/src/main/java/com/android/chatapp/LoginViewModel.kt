package com.android.chatapp

import android.util.Log
import androidx.databinding.ObservableField
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginViewModel : BaseViewModel<NavigatorLog>() {

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
                    navigator?.openHomeActivity()

                }
            }
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